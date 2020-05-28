package aaron.exam.service.service.impl;

import aaron.common.data.common.CommonRequest;
import aaron.common.data.common.CommonState;
import aaron.common.utils.CommonUtils;
import aaron.common.utils.RPCUtils;
import aaron.common.utils.TokenUtils;
import aaron.exam.service.common.exception.ExamError;
import aaron.exam.service.common.exception.ExamException;
import aaron.exam.service.dao.mapper.AnswerRecordMapper;
import aaron.exam.service.dao.mapper.ExamPublishRecordMapper;
import aaron.exam.service.dao.mapper.ExamRecordMapper;
import aaron.exam.service.manage.PaperApi;
import aaron.exam.service.pojo.DTO.report.ExamDetailQueryFormDTO;
import aaron.exam.service.pojo.DTO.report.ExamReportRecordDetailTableDataDTO;
import aaron.exam.service.pojo.DTO.report.ExamReportRecordExamTableDataDTO;
import aaron.exam.service.pojo.DTO.report.ExamReportRecordQueryFormDTO;
import aaron.exam.service.pojo.model.AnswerRecord;
import aaron.exam.service.pojo.model.ExamPublishRecord;
import aaron.exam.service.pojo.model.ExamRecord;
import aaron.exam.service.service.ReportService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Resource
    ExamPublishRecordMapper examPublishRecordMapper;

    @Resource
    ExamRecordMapper examRecordMapper;

    @Resource
    AnswerRecordMapper answerRecordMapper;

    @Autowired
    PaperApi paperApi;

    @Autowired
    CommonState commonState;

    @Override
    public List<ExamReportRecordExamTableDataDTO> query(ExamReportRecordQueryFormDTO examReportRecordQueryFormDTO) {

        Example example = new Example(ExamPublishRecord.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("title",examReportRecordQueryFormDTO.getTitle()+"%");
        criteria.andEqualTo("examSession",examReportRecordQueryFormDTO.getExamSession());
        criteria.andBetween("endTime",examReportRecordQueryFormDTO.getStartTime(),examReportRecordQueryFormDTO.getEndTime());
        try {
            List<ExamPublishRecord> recordList = examPublishRecordMapper.selectByExample(example);
            List<ExamReportRecordExamTableDataDTO> tableDataDTOS = new ArrayList<>();
            for (ExamPublishRecord examPublishRecord : recordList) {
                ExamReportRecordExamTableDataDTO tableDataDTO = new ExamReportRecordExamTableDataDTO();
                BeanUtils.copyProperties(examPublishRecord,tableDataDTO);
                Example examExample = new Example(ExamRecord.class);
                Example.Criteria examCriteria = examExample.createCriteria();
                examCriteria.andEqualTo("examPublishRecordId",examPublishRecord.getId());
                List<ExamRecord> examRecords = examRecordMapper.selectByExample(examExample);
                tableDataDTO.setActualPepoleNum(examRecords.size());
                tableDataDTOS.add(tableDataDTO);
            }
            return tableDataDTOS;
        } catch (Exception e) {
            throw new ExamException(ExamError.QUERY_ERROR);
        }
    }


    @Override
    public List<ExamReportRecordDetailTableDataDTO> queryDetail(ExamDetailQueryFormDTO examDetailQueryFormDTO) {
        Example example = new Example(ExamRecord.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("examPublishRecordId",examDetailQueryFormDTO.getId());
        example.setOrderByClause("score DESC");
        try {
            List<ExamRecord> examRecords = examRecordMapper.selectByExample(example);
            ExamPublishRecord examPublishRecord = examPublishRecordMapper.selectByPrimaryKey(examDetailQueryFormDTO.getId());
            if (examRecords!=null && examRecords.size()!=0){
                List<ExamReportRecordDetailTableDataDTO> tableDataDTOS = CommonUtils.convertList(examRecords,ExamReportRecordDetailTableDataDTO.class);
                for (ExamReportRecordDetailTableDataDTO tableDataDTO : tableDataDTOS) {
                    tableDataDTO.setTitle(examPublishRecord.getTitle());
                }
                return tableDataDTOS;
            }
        } catch (Exception e){
            throw new ExamException(ExamError.QUERY_ERROR);
        }

        return null;
    }

    @Override
    public String analysisScore(List<ExamRecord> examRecords) {
        examRecords.forEach(examRecord -> {
//            获取该场考试的答题情况
            Example example = new Example(AnswerRecord.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("examRecordId",examRecord.getId());
            List<AnswerRecord> answerRecords = answerRecordMapper.selectByExample(example);
            List<Long> subjectIds = answerRecords.stream().map(AnswerRecord::getPaperSubjectId).collect(Collectors.toList());
        });
        return null;
    }

    /**
     * 根据考试发布Id查询对应试卷满分
     *
     * @param examId
     * @return
     */
    @Override
    public Double findMaxScore(long examId) {
        ExamPublishRecord record = examPublishRecordMapper.selectByPrimaryKey(examId);
        if (record == null){
            throw new ExamException(ExamError.EXAM_RECORD_NOT_EXIST);
        }
        long paperId = record.getPaperId();
        return RPCUtils.parseResponse(paperApi.queryPaperScore(new CommonRequest<>(commonState.getVersion(), TokenUtils.getToken(),paperId)),Double.class,RPCUtils.PAPER);
    }
}

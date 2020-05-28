package aaron.exam.service.service.impl;

import aaron.common.aop.annotation.FullCommonField;
import aaron.common.utils.CommonUtils;
import aaron.common.utils.TokenUtils;
import aaron.exam.service.common.exception.ExamError;
import aaron.exam.service.common.exception.ExamException;
import aaron.exam.service.dao.mapper.AnswerRecordMapper;
import aaron.exam.service.dao.mapper.ExamPublishRecordMapper;
import aaron.exam.service.dao.mapper.ExamRecordMapper;
import aaron.exam.service.pojo.DTO.grade.*;
import aaron.exam.service.pojo.model.AnswerRecord;
import aaron.exam.service.pojo.model.ExamPublishRecord;
import aaron.exam.service.pojo.model.ExamRecord;
import aaron.exam.service.service.GradeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.*;

@Service
public class GradeServiceImpl implements GradeService {
    @Resource
    ExamPublishRecordMapper examPublishRecordMapper;
    @Resource
    AnswerRecordMapper answerRecordMapper;
    @Resource
    ExamRecordMapper examRecordMapper;

    @Override
    public List<ExamGradeRecordTableDataDTO> query(ExamGradeRecordQueryFormDTO examGradeRecordQueryFormDTO){
        List<ExamPublishRecord> examPublishRecords = examPublishRecordMapper.queryGrade(examGradeRecordQueryFormDTO);
        return convert(examPublishRecords);
    }


    @FullCommonField
    @Override
    public Boolean markingPaper(MarkingPaperDTO markingPaperDTO) {
        Example example = new Example(ExamRecord.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",markingPaperDTO.getExamRecordId());
        ExamRecord examRecord = examRecordMapper.selectOneByExample(example);
        BeanUtils.copyProperties(markingPaperDTO,examRecord);
        examRecord.setId(markingPaperDTO.getExamRecordId());
        examRecord.setActualEndTime(new Date());
        examRecord.setStatus((byte) 1);
        Map<String, Object> resultMap = markingAnswer(markingPaperDTO);
        if (resultMap.get("success").equals(true)) {
            examRecord.setObjectiveSubjectScore((Double) resultMap.get("objectiveSubjectScore"));
            examRecord.setSubjectvieSubjectScore((Double) resultMap.get("subjectiveSubjectScore"));
            if (examRecordMapper.updateByPrimaryKey(examRecord)==1){
                return true;
            }
        }
        return false;
    }


    @Override
    public List<MyAnswerDTO> getMyAnswer(Long examRecordId) {
        AnswerRecord answerRecord = new AnswerRecord();
        answerRecord.setExamRecordId(examRecordId);
        List<AnswerRecord> answerRecords = answerRecordMapper.select(answerRecord);
        if (answerRecords.size()==0){
            // 将对应的批改状态改为0分
            ExamRecord examRecord = examRecordMapper.selectByPrimaryKey(examRecordId);
            if (examRecord == null){
                throw new ExamException(ExamError.EXAM_RECORD_NOT_EXIST);
            }
            examRecord.setObjectiveSubjectScore(0.0);
            examRecord.setSubjectvieSubjectScore(0.0);
            examRecord.setScore(0.0);
            examRecord.setSystemEvaluate("未作答，自动评分");
            examRecord.setUpdatedBy(TokenUtils.getUser().getId());
            examRecord.setUpdatedTime(new Date());
            examRecord.setStatus((byte) 1);
            examRecordMapper.updateByPrimaryKey(examRecord);
            throw new ExamException(ExamError.DATA_NOT_EXIST);
        }
        return CommonUtils.convertList(answerRecords,MyAnswerDTO.class);
    }

    /**
     * 给每道题添加评分
     * @param markingPaperDTO
     * @return true or false
     */
    private Map<String, Object> markingAnswer(MarkingPaperDTO markingPaperDTO) {
        Map<String, Object> result = new HashMap<>();
        Boolean flag = false;
        Double objectiveSubjectScore = 0.0;
        Double subjectiveSubjectScore = 0.0;
        for (MarkingAnswerDTO markingAnswerDTO : markingPaperDTO.getMarkingAnswerDTOList()) {
            Example example = new Example(AnswerRecord.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("examRecordId",markingPaperDTO.getExamRecordId());
            criteria.andEqualTo("paperSubjectId",markingAnswerDTO.getPaperSubjectId());
            AnswerRecord answerRecord = answerRecordMapper.selectOneByExample(example);
            if (answerRecord != null){
                answerRecord.setScore(markingAnswerDTO.getScore());
                answerRecord.setEvaluate(markingAnswerDTO.getEvaluate());
                // 如果是客观题
                if (markingAnswerDTO.getObjectiveSubject()){
                    objectiveSubjectScore+=answerRecord.getScore();
                }
                else {
                    subjectiveSubjectScore+=answerRecord.getScore();
                }
                if (answerRecordMapper.updateByPrimaryKey(answerRecord)==1)
                    flag = true;
                else
                    return null;
            }
        }
        result.put("objectiveSubjectScore",objectiveSubjectScore);
        result.put("subjectiveSubjectScore",subjectiveSubjectScore);
        result.put("success",flag);
        return result;
    }

    private List<ExamGradeRecordTableDataDTO> convert(List<ExamPublishRecord> examPublishRecords){
        List<ExamGradeRecordTableDataDTO> tableDataDTOS = new ArrayList<>();
        for (ExamPublishRecord examPublishRecord : examPublishRecords) {
            ExamGradeRecordTableDataDTO tableDataDTO = new ExamGradeRecordTableDataDTO();
            for (ExamRecord examRecord : examPublishRecord.getExamRecords()) {
                BeanUtils.copyProperties(examRecord,tableDataDTO);
            }
            BeanUtils.copyProperties(examPublishRecord,tableDataDTO);
            tableDataDTOS.add(tableDataDTO);
        }
        return tableDataDTOS;
    }
}



package aaron.exam.service.service.impl;

import aaron.exam.service.dao.mapper.ExamPublishRecordMapper;
import aaron.exam.service.pojo.DTO.answersheet.ExamAnswerSheetRecordQueryFormDTO;
import aaron.exam.service.pojo.DTO.answersheet.ExamAnswerSheetRecordTableDataDTO;
import aaron.exam.service.pojo.model.ExamPublishRecord;
import aaron.exam.service.pojo.model.ExamRecord;
import aaron.exam.service.service.AnswerSheetRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnswerSheetRecordServiceImpl implements AnswerSheetRecordService {

    @Resource
    ExamPublishRecordMapper examPublishRecordMapper;


    @Override
    public List<ExamAnswerSheetRecordTableDataDTO> queryAnswerSheet(ExamAnswerSheetRecordQueryFormDTO examAnswerSheetRecordQueryFormDTO) {
        List<ExamPublishRecord> examPublishRecords = examPublishRecordMapper.queryAnswerRecord(examAnswerSheetRecordQueryFormDTO);
        return convert(examPublishRecords);
    }

    private List<ExamAnswerSheetRecordTableDataDTO> convert(List<ExamPublishRecord> examPublishRecords){
        List<ExamAnswerSheetRecordTableDataDTO> examAnswerSheetRecordTableDataDTOS= new ArrayList<>();
        for (ExamPublishRecord examPublishRecord : examPublishRecords) {
            ExamAnswerSheetRecordTableDataDTO examAnswerSheetRecordTableDataDTO = new ExamAnswerSheetRecordTableDataDTO();
            for (ExamRecord examRecord : examPublishRecord.getExamRecords()) {
                BeanUtils.copyProperties(examRecord,examAnswerSheetRecordTableDataDTO);
            }
            BeanUtils.copyProperties(examPublishRecord,examAnswerSheetRecordTableDataDTO);
            examAnswerSheetRecordTableDataDTOS.add(examAnswerSheetRecordTableDataDTO);
        }
        return examAnswerSheetRecordTableDataDTOS;
    }
}

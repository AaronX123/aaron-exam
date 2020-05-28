package aaron.exam.service.service;

import aaron.exam.service.pojo.DTO.answersheet.ExamAnswerSheetRecordQueryFormDTO;
import aaron.exam.service.pojo.DTO.answersheet.ExamAnswerSheetRecordTableDataDTO;

import java.util.List;

public interface AnswerSheetRecordService {
    /**
     * 获取答卷记录
     * @param examAnswerSheetRecordQueryFormDTO
     * @return
     */
    List<ExamAnswerSheetRecordTableDataDTO> queryAnswerSheet(ExamAnswerSheetRecordQueryFormDTO examAnswerSheetRecordQueryFormDTO);
}

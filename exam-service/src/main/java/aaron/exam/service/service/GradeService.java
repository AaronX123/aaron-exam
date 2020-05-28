package aaron.exam.service.service;


import aaron.exam.service.pojo.DTO.grade.ExamGradeRecordQueryFormDTO;
import aaron.exam.service.pojo.DTO.grade.ExamGradeRecordTableDataDTO;
import aaron.exam.service.pojo.DTO.grade.MarkingPaperDTO;
import aaron.exam.service.pojo.DTO.grade.MyAnswerDTO;

import java.util.List;

public interface GradeService {
    /**
     * 查询阅卷记录信息
     * @param examGradeRecordQueryFormDTO
     * @return
     */
    List<ExamGradeRecordTableDataDTO> query(ExamGradeRecordQueryFormDTO examGradeRecordQueryFormDTO);
    /**
     * 添加试卷评分信息
     * @param markingPaperDTO
     * @return
     */
    Boolean markingPaper(MarkingPaperDTO markingPaperDTO);
    /**
     * 得到我的答案和标准答案
     * @param examRecordId
     * @return 我的答案和标准答案
     */
    List<MyAnswerDTO> getMyAnswer(Long examRecordId);
}

package aaron.exam.service.dao.mapper;


import aaron.exam.service.dao.tk.mybatis.MyMapper;
import aaron.exam.service.pojo.DTO.answersheet.ExamAnswerSheetRecordQueryFormDTO;
import aaron.exam.service.pojo.DTO.grade.ExamGradeRecordQueryFormDTO;
import aaron.exam.service.pojo.DTO.publish.ExamPublishRecordDeleteFormDTO;
import aaron.exam.service.pojo.DTO.publish.ExamPublishRecordQueryFormDTO;
import aaron.exam.service.pojo.model.ExamPublishRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface ExamPublishRecordMapper extends MyMapper<ExamPublishRecord> {
    List<ExamPublishRecord> queryAnswerRecord(ExamAnswerSheetRecordQueryFormDTO examAnswerSheetRecordQueryFormDTO);
    List<ExamPublishRecord> queryExamPubulishRecord(ExamPublishRecordQueryFormDTO examPublishRecordQueryFormDTO);
    List<ExamPublishRecord> queryGrade(ExamGradeRecordQueryFormDTO examGradeRecordQueryFormDTO);
    int deleteExamPublishRecord(ExamPublishRecordDeleteFormDTO examPublishRecordDeleteFormDTO);
    @Select("SELECT id FROM exam_publish_record WHERE paper_id = #{id} ")
    List<ExamPublishRecord> listByPaperId(@Param("id") long id);
}
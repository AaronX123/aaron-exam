package aaron.exam.service.service;

import aaron.exam.service.pojo.DTO.publish.*;
import aaron.exam.service.service.impl.ExamPublishRecordServiceImpl;

import java.util.List;

/**
 * @see ExamPublishRecordServiceImpl
 */
public interface ExamPublishRecordService {
    /**
     * 获取考试发布记录
     * @param examPublishRecordQueryFormDTO
     * @return
     */
    List<ExamPublishRecordTableDataDTO> queryExamPublishRecord(ExamPublishRecordQueryFormDTO examPublishRecordQueryFormDTO);
    /**
     * 添加一条考试发布记录
     * @param examPublishRecordPublishFormDTO
     * @return true or false
     */
    boolean addExamPublishRecord(ExamPublishRecordPublishFormDTO examPublishRecordPublishFormDTO);
    /**
     * 删除考试发布记录
     * @param dtoList
     * @return
     */
    boolean deleteExamPublishRecord(List<ExamPublishRecordDeleteFormDTO> dtoList);
    /**
     * 修改考试发布记录信息
     * @param examPublishRecordEditFormDTO
     * @return
     */
    boolean updateExamPublishRecord(ExamPublishRecordEditFormDTO examPublishRecordEditFormDTO);
}

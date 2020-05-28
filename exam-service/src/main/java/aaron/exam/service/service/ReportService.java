package aaron.exam.service.service;

import aaron.exam.service.pojo.DTO.report.ExamDetailQueryFormDTO;
import aaron.exam.service.pojo.DTO.report.ExamReportRecordDetailTableDataDTO;
import aaron.exam.service.pojo.DTO.report.ExamReportRecordExamTableDataDTO;
import aaron.exam.service.pojo.DTO.report.ExamReportRecordQueryFormDTO;
import aaron.exam.service.pojo.model.ExamRecord;

import java.util.List;

public interface ReportService {
    /**
     * 获取所有考试发布记录
     * @param examReportRecordQueryFormDTO
     * @return list<ExamReportRecordExamTableDataDTO>
     */
    List<ExamReportRecordExamTableDataDTO> query(ExamReportRecordQueryFormDTO examReportRecordQueryFormDTO);
    /**
     * 获取对应每场发布记录的考试情况
     * @param examDetailQueryFormDTO
     * @return
     */
    List<ExamReportRecordDetailTableDataDTO> queryDetail(ExamDetailQueryFormDTO examDetailQueryFormDTO);

    /**
     * 分析考试成绩
     * @param examRecords
     * @return String 评价
     */
    String analysisScore(List<ExamRecord> examRecords);

    /**
     * 根据考试发布Id查询对应试卷满分
   * @param examId
     * @return
     */
    Double findMaxScore(long examId);
}

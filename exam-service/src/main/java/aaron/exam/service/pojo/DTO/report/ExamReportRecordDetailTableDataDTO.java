
package aaron.exam.service.pojo.DTO.report;

import lombok.Data;

import java.util.Date;

@Data
@SuppressWarnings("unused")
public class ExamReportRecordDetailTableDataDTO {
    private String examiner;
    private Byte sex;
    private String title;
    private Date actualStartTime;
    private Date actualEndTime;
    private Double objectiveSubjectScore;
    private Double subjectvieSubjectScore;
    private Double score;
}

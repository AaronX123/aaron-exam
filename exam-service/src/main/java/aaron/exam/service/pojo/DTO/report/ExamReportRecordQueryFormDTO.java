
package aaron.exam.service.pojo.DTO.report;

import lombok.Data;

import java.util.Date;

@Data
@SuppressWarnings("unused")
public class ExamReportRecordQueryFormDTO {

    private Integer examSession;
    private Date startTime;
    private Date endTime;
    private String publisher;
    private String title;

}

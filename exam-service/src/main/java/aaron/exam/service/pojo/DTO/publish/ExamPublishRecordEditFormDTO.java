package aaron.exam.service.pojo.DTO.publish;

import lombok.Data;

import java.util.Date;

@Data
public class ExamPublishRecordEditFormDTO {
    private Long id;
    private String descript;
    private Date startTime;
    private Date endTime;
    private Integer examSession;
    private Integer limitTime;
    private Long markingMode;
    private Date markingStopTime;
    private Long paperId;
    private Integer planPepoleNum;
    private String title;
}

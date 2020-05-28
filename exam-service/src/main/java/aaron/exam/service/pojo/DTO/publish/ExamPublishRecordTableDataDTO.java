package aaron.exam.service.pojo.DTO.publish;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ExamPublishRecordTableDataDTO {
    private Long id;
    private Long publisher;
    private Date createdTime;
    private Date endTime;
    private Integer planPepoleNum;
    private Integer limitTime;
    private String title;
    private String descript;
    private Byte status;
    private Long version;
    private Integer examSession;
    private Integer publishTimes;
    private List<Long> examiners;
    private Long paperId;
}

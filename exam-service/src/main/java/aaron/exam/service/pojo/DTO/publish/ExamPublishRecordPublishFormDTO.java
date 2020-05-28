
package aaron.exam.service.pojo.DTO.publish;

import aaron.common.data.common.BaseDto;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@SuppressWarnings("unused")
public class ExamPublishRecordPublishFormDTO extends BaseDto {
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
    private List<Long> examinersId;
    private Long publisher;
}

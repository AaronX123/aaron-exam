
package aaron.exam.service.pojo.VO.publish;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@SuppressWarnings("unused")
public class ExamPublishRecordPublishFormVO implements Serializable {
    private static final long serialVersionUID = 5693809321529280897L;
    /**
     * 描述
     */
    private String descript;
    /**
     * 考试开始时间
     */
    @NotNull(message = "考试开始时间不能为空")
    private Date startTime;
    /**
     * 考试结束时间
     */
    @NotNull(message = "考试结束时间不能为空")
    private Date endTime;
    /**
     * 考试场次
     */
    @NotNull(message = "考试场次不能为空")
    private Integer examSession;
    /**
     * 考试限制时间
     */
    @NotNull(message = "考试时间不能为空")
    private Integer limitTime;
    /**
     * 阅卷方式
     */
    @NotNull(message = "阅卷方式不能为空")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long markingMode;
    /**
     * 阅卷截止时间
     */
    @NotNull(message = "阅卷截止时间不能为空")
    private Date markingStopTime;
    /**
     * 试卷id
     */
    @NotNull(message = "试卷id不能为空")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long paperId;
    /**
     * 计划考试人数
     */
    @NotNull(message = "计划人数不能为空")
    private Integer planPepoleNum;
    /**
     * 考试标题
     */
    @NotBlank(message = "考试标题不能为空")
    private String title;
    /**
     * 阅卷官列表
     */
    @NotEmpty(message = "阅卷官不能为空")
    private List<Long> examinersId;
}

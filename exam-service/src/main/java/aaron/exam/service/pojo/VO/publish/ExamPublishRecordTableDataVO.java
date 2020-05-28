package aaron.exam.service.pojo.VO.publish;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

@Data
public class ExamPublishRecordTableDataVO implements Serializable {
    private static final long serialVersionUID = 4108085086798920153L;
    /**
     * 考试发布记录id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 发布人
     */
    private String publisher;
    /**
     * 发布时间
     */
    private String createdTime;
    /**
     * 考试结束时间
     */
    private String endTime;
    /**
     * 计划人数
     */
    private Integer planPepoleNum;
    /**
     * 考试时间
     */
    private Integer limitTime;
    /**
     * 考试标题
     */
    private String title;
    /**
     * 描述
     */
    private String descript;
    /**
     * 状态
     */
    private String status;
    /**
     * 考试场次
     */
    private Integer examSession;
    /**
     * 版本
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long version;
    /**
     * 发布次数
     */
    private Integer publishTimes;
    /**
     * 阅卷官姓名
     */
    private String examiners;
    /**
     * 试卷id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long paperId;
}

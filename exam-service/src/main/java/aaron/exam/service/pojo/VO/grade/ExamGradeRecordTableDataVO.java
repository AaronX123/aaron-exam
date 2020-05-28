
package aaron.exam.service.pojo.VO.grade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

@Data
@SuppressWarnings("unused")
public class ExamGradeRecordTableDataVO implements Serializable {
    private static final long serialVersionUID = 7088103230127300568L;
    /**
     * 考试记录id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 交卷时间
     */
    private String actualEndTime;
    /**
     * 考试场次
     */
    private Integer examSession;
    /**
     * 考生姓名
     */
    private String examiner;
    /**
     * 阅卷截止时间
     */
    private String markingStopTime;
    /**
     * 客观题分数
     */
    private Double objectiveSubjectScore;
    /**
     * 试卷id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long paperId;
    /**
     * 试卷名
     */
    private String paperName;
    /**
     * 创建时间
     */
    private String createdTime;
    /**
     * 状态
     */
    private String status;
    /**
     * 主观题分数
     */
    private Double subjectvieSubjectScore;
    /**
     * 系统评价
     */
    private String systemEvaluate;
    /**
     * 考生手机号
     */
    private String tel;
}

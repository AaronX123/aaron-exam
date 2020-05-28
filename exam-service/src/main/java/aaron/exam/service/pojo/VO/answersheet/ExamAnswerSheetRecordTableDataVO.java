
package aaron.exam.service.pojo.VO.answersheet;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

@Data
@SuppressWarnings("unused")
public class ExamAnswerSheetRecordTableDataVO implements Serializable {
    private static final long serialVersionUID = -638375108358453159L;
    /**
     * 考试纪录id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 考试结束时间
     */
    private String actualEndTime;
    /**
     * 考试开始时间
     */
    private String actualStartTime;
    /**
     * 考试截止时间
     */
    private String endTime;
    /**
     * 考试发布人
     */
    private String publisher;
    /**
     * 考试场次
     */
    private Integer examSession;
    /**
     * 答卷人姓名
     */
    private String examiner;
    /**
     * 客观主观题分数
     */
    private Double objectiveSubjectScore;
    private Double subjectvieSubjectScore;
    /**
     * 答卷人手机号
     */
    private String tel;
    /**
     * 考试名
     */
    private String title;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long paperId;
}

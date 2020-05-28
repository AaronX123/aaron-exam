package aaron.exam.service.pojo.VO.grade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class MarkingPaperVO implements Serializable {
    private static final long serialVersionUID = 7401740619745410232L;
    /**
     * 试卷分数
     */
    @NotNull(message = "分数不能为空")
    private Double score;
    /**
     * 系统评价
     */
    @NotBlank(message = "系统评价不能为空")
    private String systemEvaluate;
    /**
     * 考试记录id
     */
    @NotNull(message = "考试记录id不能为空")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long examRecordId;
    /**
     * 题目评分列表
     */
    @NotEmpty(message = "题目列表不能为空")
    List<MarkingAnswerVO> markingAnswerVOList;
}

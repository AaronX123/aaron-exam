package aaron.exam.service.pojo.VO.grade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class MarkingAnswerVO implements Serializable {
    private static final long serialVersionUID = -7206074114934998045L;
    /**
     * 是否未客观题
     */
    private Boolean objectiveSubject;
    /**
     * 该题分数
     */
    @NotNull(message = "分数不能为空")
    private Double score;
    /**
     * 该题评价
     */
    private String evaluate;
    /**
     * 试卷id
     */
    @NotNull(message = "试卷id不能为空")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long paperSubjectId;
}

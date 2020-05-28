package aaron.exam.service.pojo.VO.grade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

/**
 * @Classname MyAnswerVO
 * @Date 2019/9/17 20:38
 * @Created by SYT
 */
@Data
public class MyAnswerVO implements Serializable {
    private static final long serialVersionUID = -3850684397101787865L;
    /**
     * 我的答案
     */
    private String myAnswer;
    /**
     * 标准答案
     */
    private String standardAnswer;
    /**
     * 试题id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long paperSubjectId;
}

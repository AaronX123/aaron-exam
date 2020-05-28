package aaron.exam.service.pojo.DTO.grade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * @Classname MyAnswerVO
 * @Date 2019/9/17 20:38
 * @Created by SYT
 */
@Data
public class MyAnswerDTO {
    private String myAnswer;
    private String standardAnswer;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long paperSubjectId;
}

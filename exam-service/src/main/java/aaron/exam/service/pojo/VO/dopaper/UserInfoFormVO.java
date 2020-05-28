package aaron.exam.service.pojo.VO.dopaper;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class UserInfoFormVO implements Serializable {
    private static final long serialVersionUID = -7292684340391897477L;
    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空！")
    private String tel;
    /**
     * 姓名
     */
    @NotBlank(message = "名字不能为空！")
    private String examiner;
    /**
     * 性别
     */
    @Max(2)
    @NotNull(message = "性别不能为空！")
    private Byte sex;
    /**
     * 考试发布记录id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long examPublishRecordId;
}

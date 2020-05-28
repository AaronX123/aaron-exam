
package aaron.exam.service.pojo.VO.publish;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@SuppressWarnings("unused")
public class ExamPublishRecordDeleteFormVO implements Serializable {
    private static final long serialVersionUID = 8295050066068465696L;
    /**
     * 考试发布记录id
     */
    @NotNull(message = "发布记录id不能为空")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 版本
     */
    @NotNull(message = "版本不能为空")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long version;
}

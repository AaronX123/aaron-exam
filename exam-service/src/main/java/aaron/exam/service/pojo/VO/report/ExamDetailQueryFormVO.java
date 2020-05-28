
package aaron.exam.service.pojo.VO.report;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

@Data
@SuppressWarnings("unused")
public class ExamDetailQueryFormVO implements Serializable {
    private static final long serialVersionUID = -8596837586676542893L;
    /**
     * 考试发布记录id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    private Integer currentPage;
}

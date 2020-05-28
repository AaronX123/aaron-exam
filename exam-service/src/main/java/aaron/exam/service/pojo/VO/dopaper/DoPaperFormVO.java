package aaron.exam.service.pojo.VO.dopaper;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

@Data
public class DoPaperFormVO implements Serializable {
    private static final long serialVersionUID = 7493564724724767532L;
    private String standardAnswer;
    private String myAnswer;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long examRecordId;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long paperSubjectId;
}
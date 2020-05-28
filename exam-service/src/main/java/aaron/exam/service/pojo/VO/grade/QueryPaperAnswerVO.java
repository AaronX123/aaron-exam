package aaron.exam.service.pojo.VO.grade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

@Data
public class QueryPaperAnswerVO implements Serializable {
    private static final long serialVersionUID = 7400252474453798598L;
    /**
     * 试卷id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long paperId;
    /**
     * 考试记录id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long examRecordId;
}

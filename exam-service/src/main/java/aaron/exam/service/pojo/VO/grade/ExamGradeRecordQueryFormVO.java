
package aaron.exam.service.pojo.VO.grade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@SuppressWarnings("unused")
public class ExamGradeRecordQueryFormVO implements Serializable {
    private static final long serialVersionUID = -6906954436220705491L;
    /**
     * 交卷时间段
     */
    private List<Date> endTimeRange;
    /**
     * 状态
     */
    private Byte status;
    /**
     * 考试场次
     */
    private Integer examSession;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long userId;
    private Integer currentPage;
}

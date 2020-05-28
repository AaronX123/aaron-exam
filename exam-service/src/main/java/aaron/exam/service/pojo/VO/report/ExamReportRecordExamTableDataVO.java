
package aaron.exam.service.pojo.VO.report;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.io.Serializable;

@Data
@SuppressWarnings("unused")
public class ExamReportRecordExamTableDataVO implements Serializable {
    private static final long serialVersionUID = 4496661543421891194L;
    /**
     * 考试记录id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
     * 实际考试人数
     */
    private Integer actualPepoleNum;
    /**
     * 考试结束时间
     */
    private String endTime;
    /**
     * 考试场次
     */
    private Integer examSession;
    /**
     * 计划考试人数
     */
    private Integer planPepoleNum;
    /**
     * 考试标题
     */
    private String title;
}

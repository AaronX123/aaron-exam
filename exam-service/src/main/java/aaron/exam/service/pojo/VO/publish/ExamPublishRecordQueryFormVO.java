
package aaron.exam.service.pojo.VO.publish;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@SuppressWarnings("unused")
public class ExamPublishRecordQueryFormVO implements Serializable {
    private static final long serialVersionUID = 8832347497857830169L;
    /**
     * 考试时间段
     */
    private List<Date> examTimeRange;
    /**
     * 发布时间段
     */
    private List<Date> publishTimeRange;
    /**
     * 发布人
     */
    private String publisher;
    /**
     * 考试标题
     */
    private String title;
    private Integer currentPage;
}

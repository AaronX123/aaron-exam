
package aaron.exam.service.pojo.VO.answersheet;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@SuppressWarnings("unused")
public class ExamAnswerSheetRecordQueryFormVO implements Serializable {
    private static final long serialVersionUID = 198994862820429412L;
    /**
     * 考试场次
     */
    private Integer examSession;

    /**
     * 考试时间段
     */
    private List<Date> examTimeRange;
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

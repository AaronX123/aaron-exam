package aaron.exam.service.pojo.VO.publish;

import lombok.Data;

import java.io.Serializable;

@Data
public class ExamPublishRecordPaperDialogQueryFormVO implements Serializable {
    private static final long serialVersionUID = -6558773636289175818L;
    /**
     * 试卷名
     */
    private String paper;
}

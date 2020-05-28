package aaron.exam.service.pojo.VO.publish;

import lombok.Data;

import java.io.Serializable;

@Data
public class ExamPublishRecordExaminersDialogQueryFormVO implements Serializable {
    private static final long serialVersionUID = 7617926042166562609L;
    /**
     * 阅卷官姓名
     */
    private String examiner;
}

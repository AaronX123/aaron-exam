package aaron.exam.service.pojo.VO.publish;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ExamPublishRecordExaminersTableDataVO implements Serializable {
    private static final long serialVersionUID = -7183326462650625887L;
    /**
     * 阅卷官列表
     */
    private List<String> examiners;
}

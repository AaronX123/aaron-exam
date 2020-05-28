
package aaron.exam.service.pojo.DTO.grade;

import lombok.Data;

import java.util.List;

@Data
@SuppressWarnings("unused")
public class ExamGradeRecordQueryFormDTO {

    private List<String> endTimeRange;
    private Byte status;
    private Integer examSession;
    private Long userId;

}


package aaron.exam.service.pojo.DTO.answersheet;

import lombok.Data;

import java.util.List;

@Data
@SuppressWarnings("unused")
public class ExamAnswerSheetRecordQueryFormDTO {

    private Integer examSession;
    private List<String> examTimeRange;
    private Long publisher;
    private String title;

}


package aaron.exam.service.pojo.DTO.publish;

import lombok.Data;

import java.util.List;

@Data
@SuppressWarnings("unused")
public class ExamPublishRecordQueryFormDTO {

    private List<String> examTimeRange;
    private List<String> publishTimeRange;
    private Long publisher;
    private String title;

}

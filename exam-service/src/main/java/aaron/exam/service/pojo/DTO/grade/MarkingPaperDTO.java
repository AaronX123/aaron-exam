package aaron.exam.service.pojo.DTO.grade;


import aaron.common.data.common.BaseDto;
import lombok.Data;

import java.util.List;

@Data
public class MarkingPaperDTO extends BaseDto {
    private Double score;
    private String systemEvaluate;
    private Long examRecordId;
    List<MarkingAnswerDTO> markingAnswerDTOList;
}

package aaron.exam.service.pojo.DTO.grade;

import lombok.Data;

@Data
public class MarkingAnswerDTO {
    private Boolean objectiveSubject;
    private Double score;
    private String evaluate;
    private Long paperSubjectId;
}

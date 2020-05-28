package aaron.exam.service.pojo.DTO.dopaper;

import lombok.Data;

@Data
public class DoPaperFormDTO {
    private String standardAnswer;
    private String myAnswer;
    private Long examRecordId;
    private Long paperSubjectId;
    private String subjectType;
}

package aaron.exam.service.pojo.DTO.dopaper;

import lombok.Data;

@Data
public class UserInfoFormDTO {
    private String tel;
    private String examiner;
    private Byte sex;
    private Long examPublishRecordId;
}

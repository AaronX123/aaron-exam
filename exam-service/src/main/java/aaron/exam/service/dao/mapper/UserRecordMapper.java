package aaron.exam.service.dao.mapper;


import aaron.exam.service.dao.tk.mybatis.MyMapper;
import aaron.exam.service.pojo.model.UserRecord;

import java.util.List;


public interface UserRecordMapper extends MyMapper<UserRecord> {
    List<UserRecord> listExaminers(Long examPublishRecordId);
}
package aaron.exam.service.service.impl;


import aaron.common.aop.annotation.FullCommonField;
import aaron.common.utils.CommonUtils;
import aaron.common.utils.TokenUtils;
import aaron.common.utils.jwt.UserPermission;
import aaron.exam.service.common.exception.ExamError;
import aaron.exam.service.common.exception.ExamException;
import aaron.exam.service.dao.mapper.ExamPublishRecordMapper;
import aaron.exam.service.dao.mapper.UserRecordMapper;
import aaron.exam.service.pojo.DTO.publish.*;
import aaron.exam.service.pojo.model.ExamPublishRecord;
import aaron.exam.service.pojo.model.UserRecord;
import aaron.exam.service.service.ExamPublishRecordService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExamPublishRecordServiceImpl implements ExamPublishRecordService {

    @Resource
    private ExamPublishRecordMapper examPublishRecordMapper;

    @Resource
    private UserRecordMapper userRecordMapper;


    @Override
    public List<ExamPublishRecordTableDataDTO> queryExamPublishRecord(ExamPublishRecordQueryFormDTO examPublishRecordQueryFormDTO) {
        List<ExamPublishRecord> examPublishRecords = examPublishRecordMapper.queryExamPubulishRecord(examPublishRecordQueryFormDTO);
        if (examPublishRecords!=null && examPublishRecords.size()!=0) {
            List<ExamPublishRecordTableDataDTO> examPublishRecordTableDataDTOS = CommonUtils.convertList(examPublishRecords,ExamPublishRecordTableDataDTO.class);
            examPublishRecordTableDataDTOS.forEach(dto -> {
                UserRecord userRecord = new UserRecord();
                userRecord.setExamPublishRecordId(dto.getId());
                List<UserRecord> selected = userRecordMapper.select(userRecord);
                List<Long> examiners = selected.stream().map(UserRecord::getId).collect(Collectors.toList());
                dto.setExaminers(examiners);
            });
            return examPublishRecordTableDataDTOS;
        }
        return new ArrayList<>();
    }


    @FullCommonField
    @Override
    public boolean addExamPublishRecord(ExamPublishRecordPublishFormDTO examPublishRecordPublishFormDTO) {
        ExamPublishRecord examPublishRecord = new ExamPublishRecord();
        UserRecord userRecord = new UserRecord();
        UserPermission userPermission = TokenUtils.getUser();
        examPublishRecordPublishFormDTO.setPublisher(userPermission.getId());
        BeanUtils.copyProperties(examPublishRecordPublishFormDTO,examPublishRecord);
        examPublishRecord.setStatus((byte) 0);
        userRecord.setExamPublishRecordId(examPublishRecordPublishFormDTO.getId());
        List<Long> idList = examPublishRecordPublishFormDTO.getExaminersId();
        if (idList!=null){
            idList.forEach(id -> {
                userRecord.setId(id);
                userRecordMapper.insert(userRecord);
            });
        }
        if (examPublishRecordMapper.insert(examPublishRecord)==1){
            return true;
        }
        return false;
    }


    @Override
    public boolean deleteExamPublishRecord(List<ExamPublishRecordDeleteFormDTO> dtoList) {
        for (ExamPublishRecordDeleteFormDTO dto : dtoList) {
            Example example = new Example(ExamPublishRecord.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("id",dto.getId());
            criteria.andEqualTo("version",dto.getVersion());
            ExamPublishRecord examPublishRecord = examPublishRecordMapper.selectOneByExample(example);
            if (examPublishRecord.getStatus()!=0){
                throw new ExamException(ExamError.PAPER_IS_PUBLISHED);
            }
            examPublishRecordMapper.deleteExamPublishRecord(dto);
        }
        return true;
    }


    @Override
    public boolean updateExamPublishRecord(ExamPublishRecordEditFormDTO examPublishRecordEditFormDTO) {
        ExamPublishRecord examPublishRecord = new ExamPublishRecord();
        ExamPublishRecord oldPo = examPublishRecordMapper.selectByPrimaryKey(examPublishRecordEditFormDTO.getId());
        BeanUtils.copyProperties(oldPo,examPublishRecord);
        BeanUtils.copyProperties(examPublishRecordEditFormDTO,examPublishRecord);
        if(examPublishRecordMapper.updateByPrimaryKey(examPublishRecord)==1)
            return true;
        return false;
    }
}


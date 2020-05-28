package aaron.exam.service.service.impl;

import aaron.common.utils.SnowFlake;
import aaron.exam.service.common.exception.ExamError;
import aaron.exam.service.common.exception.ExamException;
import aaron.exam.service.dao.mapper.AnswerRecordMapper;
import aaron.exam.service.dao.mapper.ExamPublishRecordMapper;
import aaron.exam.service.dao.mapper.ExamRecordMapper;
import aaron.exam.service.dao.mapper.UserRecordMapper;
import aaron.exam.service.pojo.DTO.dopaper.DoPaperFormDTO;
import aaron.exam.service.pojo.DTO.dopaper.UserInfoFormDTO;
import aaron.exam.service.pojo.VO.dopaper.TimeWrapper;
import aaron.exam.service.pojo.model.AnswerRecord;
import aaron.exam.service.pojo.model.ExamPublishRecord;
import aaron.exam.service.pojo.model.ExamRecord;
import aaron.exam.service.pojo.model.UserRecord;
import aaron.exam.service.service.DoPaperService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class DoPaperServiceImpl implements DoPaperService {
    @Resource
    ExamRecordMapper examRecordMapper;

    @Resource
    AnswerRecordMapper answerRecordMapper;

    @Resource
    ExamPublishRecordMapper examPublishRecordMapper;

    @Resource
    UserRecordMapper userRecordMapper;

    @Resource
    SnowFlake snowFlake;

    private Integer count = 0;

    @Override
    public Long saveExaminee(UserInfoFormDTO userInfoFormDTO) {
        Example example = new Example(ExamRecord.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("tel",userInfoFormDTO.getTel());
        ExamRecord record = examRecordMapper.selectOneByExample(example);
        if (record==null) {
            try {
                ExamRecord examRecord = new ExamRecord();
                examRecord.setId(snowFlake.nextId());
                examRecord.setActualStartTime(new Date());
                examRecord.setStatus((byte) 0);
                BeanUtils.copyProperties(userInfoFormDTO, examRecord);
                //id从dto拿 找到publish的开始结束时间
                ExamPublishRecord examPublishRecord = examPublishRecordMapper.selectByPrimaryKey(examRecord.getExamPublishRecordId());
                examPublishRecord.setStatus((byte) 1);
                examPublishRecordMapper.updateByPrimaryKey(examPublishRecord);
                // 添加阅卷官
                List<UserRecord> userRecords = userRecordMapper.listExaminers(examPublishRecord.getId());
                examRecord.setUserId(userRecords.get(count++ % userRecords.size()).getId());
                examRecord.setPlanStartTime(examPublishRecord.getStartTime());
                examRecord.setPlanEndTime(examPublishRecord.getEndTime());
                if (examRecordMapper.insert(examRecord) == 1)
                    return examRecord.getId();
            } catch (Exception e) {
                throw new ExamException(ExamError.SAVE_USER_ERROR);
            }
        }
        else {
            return record.getId();
        }
        return null;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean addMyAnswer(List<DoPaperFormDTO> doPaperFormDTOList) {
        ExamRecord examRecord = examRecordMapper.selectByPrimaryKey(doPaperFormDTOList.get(0).getExamRecordId());
        examRecord.setActualEndTime(new Date());
        examRecordMapper.updateByPrimaryKey(examRecord);
        Boolean flag = false;
//        查询是否存在答案记录
        for (DoPaperFormDTO doPaperFormDTO : doPaperFormDTOList) {
            Example example = new Example(AnswerRecord.class);
            Example.Criteria criteria = example.createCriteria();
            criteria.andEqualTo("myAnswer",doPaperFormDTO.getMyAnswer());
            criteria.andEqualTo("paperSubjectId",doPaperFormDTO.getPaperSubjectId());
            criteria.andEqualTo("examRecordId",doPaperFormDTO.getExamRecordId());
            AnswerRecord answerRecord = answerRecordMapper.selectOneByExample(example);
            if (answerRecord==null) {
                AnswerRecord newAnswer = new AnswerRecord();
                newAnswer.setId(snowFlake.nextId());
                BeanUtils.copyProperties(doPaperFormDTO, newAnswer);
                // 判断是否为客观题
                if (answerRecordMapper.insert(newAnswer) == 1) {
                    flag = true;
                } else {
                    return false;
                }
            }
        }
        return flag;
    }

    /**
     * 获取考试持续时间
     *
     * @param id
     * @return
     */
    @Override
    public TimeWrapper getExamTime(long id) {
        ExamPublishRecord examPublishRecord = examPublishRecordMapper.selectByPrimaryKey(id);
        int time = examPublishRecord.getLimitTime();
        TimeWrapper wrapper = new TimeWrapper();
        wrapper.setHour(time / 60);
        wrapper.setMin(time % 60);
        return wrapper;
    }

}

package aaron.exam.service.service;


import aaron.exam.service.pojo.DTO.dopaper.DoPaperFormDTO;
import aaron.exam.service.pojo.DTO.dopaper.UserInfoFormDTO;
import aaron.exam.service.pojo.VO.dopaper.TimeWrapper;

import java.util.List;

public interface DoPaperService {
    /**
     * 扫码后用户不存在添加
     * @param userInfoFormDTO
     * @return 考试发布记录id
     */
    Long saveExaminee(UserInfoFormDTO userInfoFormDTO);
    /**
     * 填写答案 存入答案
     * @param
     * @return
     */
    Boolean addMyAnswer(List<DoPaperFormDTO> doPaperFormDTOList);

    /**
     * 获取考试持续时间
     * @param id
     * @return
     */
    TimeWrapper getExamTime(long id);
}

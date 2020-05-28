package aaron.exam.service.controller;


import aaron.common.data.common.CommonRequest;
import aaron.common.data.common.CommonResponse;
import aaron.common.data.common.CommonState;
import aaron.common.data.exception.StarterError;
import aaron.common.logging.annotation.MethodEnhancer;
import aaron.common.utils.CommonUtils;
import aaron.common.utils.RPCUtils;
import aaron.exam.service.common.exception.ExamError;
import aaron.exam.service.common.exception.ExamException;
import aaron.exam.service.manage.PaperApi;
import aaron.exam.service.pojo.DTO.dopaper.DoPaperFormDTO;
import aaron.exam.service.pojo.DTO.dopaper.UserInfoFormDTO;
import aaron.exam.service.pojo.VO.dopaper.DoPaperFormVO;
import aaron.exam.service.pojo.VO.dopaper.TimeWrapper;
import aaron.exam.service.pojo.VO.dopaper.UserInfoFormVO;
import aaron.exam.service.service.DoPaperService;
import aaron.paper.api.dto.PaperDetail;
import feign.RetryableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("dopaper")
public class DoPaperController {
    @Autowired
    CommonState state;

    @Autowired
    DoPaperService doPaperService;

    @Autowired
    PaperApi paperApi;

    /**
     * 保存考生信息
     * @param userInfoFormVO
     * @return commonResponse
     */
    @MethodEnhancer
    @RequestMapping(value = "saveexaminer")
    public CommonResponse<String> saveExaminer(@RequestBody @Valid UserInfoFormVO userInfoFormVO){
        UserInfoFormDTO userInfoFormDTO = CommonUtils.copyProperties(userInfoFormVO,UserInfoFormDTO.class);
        Long examId = doPaperService.saveExaminee(userInfoFormDTO);
        if (null != examId){
            return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,examId.toString());
        }
        return new CommonResponse<>(state.SUCCESS, state.FAIL_MSG,null);
    }

    /**
     * 添加答案
     * @param doPaperFormVOS
     * @return commonResponse
     */
    @MethodEnhancer
    @RequestMapping(value = "addanswer")
    public CommonResponse addAnswer(@RequestBody List<DoPaperFormVO> doPaperFormVOS){
        List<DoPaperFormDTO> doPaperFormDTOS = CommonUtils.convertList(doPaperFormVOS,DoPaperFormDTO.class);
        doPaperService.addMyAnswer(doPaperFormDTOS);
        return new CommonResponse(state.SUCCESS, state.SUCCESS_MSG,"success");
    }

    /**
     * 获取试卷信息
     * @param commonRequest paperId
     * @return commonResponse
     */
    @MethodEnhancer
    @RequestMapping(value = "getPaper")
    public CommonResponse<PaperDetail> getPaper(@RequestBody CommonRequest<Long> commonRequest){
        PaperDetail detail = RPCUtils.parseResponse(paperApi.queryDetailByPaperId(commonRequest), PaperDetail.class,RPCUtils.PAPER);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,detail);
    }

    @MethodEnhancer
    @RequestMapping(value = "getExamTime")
    public CommonResponse<TimeWrapper> getExamTime(@RequestBody CommonRequest<Long> request){
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,doPaperService.getExamTime(request.getData()));
    }
}

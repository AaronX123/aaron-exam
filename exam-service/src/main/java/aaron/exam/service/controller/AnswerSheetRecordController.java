package aaron.exam.service.controller;

import aaron.common.data.common.CommonRequest;
import aaron.common.data.common.CommonResponse;
import aaron.common.data.common.CommonState;
import aaron.common.logging.annotation.MethodEnhancer;
import aaron.common.utils.RPCUtils;
import aaron.common.utils.TokenUtils;
import aaron.exam.service.common.utils.DateFormatUtil;
import aaron.exam.service.common.utils.DateToString;
import aaron.exam.service.manage.UserApi;
import aaron.exam.service.pojo.DTO.answersheet.ExamAnswerSheetRecordQueryFormDTO;
import aaron.exam.service.pojo.DTO.answersheet.ExamAnswerSheetRecordTableDataDTO;
import aaron.exam.service.pojo.VO.answersheet.ExamAnswerSheetRecordQueryFormVO;
import aaron.exam.service.pojo.VO.answersheet.ExamAnswerSheetRecordTableDataVO;
import aaron.exam.service.service.AnswerSheetRecordService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("answersheet")
public class AnswerSheetRecordController {
    @Autowired
    CommonState state;

    @Autowired
    private AnswerSheetRecordService answerSheetRecordService;

    @Autowired
    private UserApi userFeignClient;

    private final static Integer PAGE_SIZE = 8;

    @MethodEnhancer
    @RequestMapping(value = "getanswersheet",method = RequestMethod.POST)
    public CommonResponse<Map> queryAll(@RequestBody CommonRequest<ExamAnswerSheetRecordQueryFormVO> commonRequest){
        ExamAnswerSheetRecordQueryFormVO examAnswerSheetRecordQueryFormVO = commonRequest.getData();
        ExamAnswerSheetRecordQueryFormDTO examAnswerSheetRecordQueryFormDTO = new ExamAnswerSheetRecordQueryFormDTO();
        BeanUtils.copyProperties(examAnswerSheetRecordQueryFormVO,examAnswerSheetRecordQueryFormDTO);
        if (examAnswerSheetRecordQueryFormVO.getPublisher()!=null) {
            examAnswerSheetRecordQueryFormDTO.setPublisher(getPublisherId(examAnswerSheetRecordQueryFormVO.getPublisher()));
        }
        if(examAnswerSheetRecordQueryFormVO.getExamTimeRange()!=null&&examAnswerSheetRecordQueryFormVO.getExamTimeRange().size()!=0)
        {
            List<String> examTimeRange = DateToString.convert(examAnswerSheetRecordQueryFormVO.getExamTimeRange());
            examAnswerSheetRecordQueryFormDTO.setExamTimeRange(examTimeRange);
        }
        Page p = PageHelper.startPage(examAnswerSheetRecordQueryFormVO.getCurrentPage(),PAGE_SIZE);
        List<ExamAnswerSheetRecordTableDataDTO> tableDataDTOS = answerSheetRecordService.queryAnswerSheet(examAnswerSheetRecordQueryFormDTO);
        List<ExamAnswerSheetRecordTableDataVO> tableDataVOS = new ArrayList<ExamAnswerSheetRecordTableDataVO>();
        for (ExamAnswerSheetRecordTableDataDTO tableDataDTO : tableDataDTOS) {
            ExamAnswerSheetRecordTableDataVO tableDataVO = new ExamAnswerSheetRecordTableDataVO();
            BeanUtils.copyProperties(tableDataDTO,tableDataVO);
            tableDataVO.setEndTime(DateFormatUtil.format(tableDataDTO.getEndTime()));
            tableDataVO.setActualEndTime(DateFormatUtil.format(tableDataDTO.getActualEndTime()));
            tableDataVO.setActualStartTime(DateFormatUtil.format(tableDataDTO.getActualStartTime()));
            tableDataVO.setPublisher(getPublisherName(tableDataDTO.getPublisher()));
            tableDataVOS.add(tableDataVO);
        }
        PageInfo<ExamAnswerSheetRecordTableDataVO> pageInfo = new PageInfo<>(tableDataVOS);
        Map<String,Object> map = new HashMap<>();
        map.put("total",p.getTotal());
        map.put("pageInfo",pageInfo);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,map);
    }

    /**
     * 通过id获取userName
     * @param id
     * @return
     */
    private String getPublisherName(Long id){
        if (id!=null) {
            CommonRequest<Long> request = new CommonRequest<>();
            request.setVersion(state.getVersion());
            request.setData(id);
            request.setToken(TokenUtils.getToken());
            return RPCUtils.parseResponse(userFeignClient.getUserNameById(request), String.class,RPCUtils.USER);
        }
        return null;
    }

    /**
     * 通过名字获取人物id
     * @param name
     * @return
     */
    private Long getPublisherId(String name){
        if (name!=null){
            CommonRequest<String> request = new CommonRequest<>();
            request.setVersion(state.getVersion());
            request.setToken(TokenUtils.getToken());
            request.setData(name);
            Long id = RPCUtils.parseResponse(userFeignClient.getUserIdByName(request), Long.class,RPCUtils.USER);
            if (id!=null) {
                return id;
            }
            else {
                return 0L;
            }
        }
        return null;
    }
}

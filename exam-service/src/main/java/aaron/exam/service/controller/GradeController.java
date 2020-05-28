package aaron.exam.service.controller;

import aaron.common.data.common.CommonRequest;
import aaron.common.data.common.CommonResponse;
import aaron.common.data.common.CommonState;
import aaron.common.logging.annotation.MethodEnhancer;
import aaron.common.utils.CommonUtils;
import aaron.common.utils.RPCUtils;
import aaron.exam.service.common.utils.DateFormatUtil;
import aaron.exam.service.common.utils.DateToString;
import aaron.exam.service.manage.PaperApi;
import aaron.exam.service.pojo.DTO.grade.*;
import aaron.exam.service.pojo.VO.grade.ExamGradeRecordQueryFormVO;
import aaron.exam.service.pojo.VO.grade.ExamGradeRecordTableDataVO;
import aaron.exam.service.pojo.VO.grade.MarkingPaperVO;
import aaron.exam.service.pojo.VO.grade.MyAnswerVO;
import aaron.exam.service.service.GradeService;
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
@RequestMapping("grade")
public class GradeController {

    private final static Integer PAGE_SIZE = 8;

    @Autowired
    PaperApi paperApi;

    @Autowired
    GradeService gradeService;

    @Autowired
    CommonState state;

    @MethodEnhancer
    @RequestMapping(value = "query",method = RequestMethod.POST)
    public CommonResponse<Map> query(@RequestBody CommonRequest<ExamGradeRecordQueryFormVO> commonRequest){
        ExamGradeRecordQueryFormVO queryFormVO = commonRequest.getData();
        ExamGradeRecordQueryFormDTO queryFormDTO = CommonUtils.copyProperties(commonRequest.getData(),ExamGradeRecordQueryFormDTO.class);
        if(queryFormVO.getEndTimeRange()!=null && queryFormVO.getEndTimeRange().size()!=0){
            List<String> endTimeRange = DateToString.convert(queryFormVO.getEndTimeRange());
            queryFormDTO.setEndTimeRange(endTimeRange);
        }
        Page p = PageHelper.startPage(queryFormVO.getCurrentPage(),PAGE_SIZE);
        List<ExamGradeRecordTableDataDTO> tableDataDTOS = gradeService.query(queryFormDTO);
        List<ExamGradeRecordTableDataVO> tableDataVOS = new ArrayList<>();
        for (ExamGradeRecordTableDataDTO tableDataDTO : tableDataDTOS) {
            ExamGradeRecordTableDataVO tableDataVO = CommonUtils.copyProperties(tableDataDTO,ExamGradeRecordTableDataVO.class);
            tableDataVO.setPaperName(getPaperName(tableDataDTO.getPaperId(),commonRequest));
            tableDataVO.setCreatedTime(DateFormatUtil.format(tableDataDTO.getCreatedTime()));
            tableDataVO.setActualEndTime(DateFormatUtil.format(tableDataDTO.getActualEndTime()));
            tableDataVO.setMarkingStopTime(DateFormatUtil.format(tableDataDTO.getMarkingStopTime()));
            setVoStatus(tableDataVO,tableDataDTO);
            tableDataVOS.add(tableDataVO);
        }
        PageInfo<ExamGradeRecordTableDataVO> pageInfo = new PageInfo<>(tableDataVOS);
        Map<String,Object> map = new HashMap<>();
        map.put("total",p.getTotal());
        map.put("pageInfo",pageInfo);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,map);

    }


    @MethodEnhancer
    @RequestMapping(value = "markingpaper",method = RequestMethod.POST)
    public CommonResponse<Boolean> markingPaper(@RequestBody CommonRequest<MarkingPaperVO> commonRequest){
        MarkingPaperVO markingPaperVO = commonRequest.getData();
        MarkingPaperDTO markingPaperDTO = new MarkingPaperDTO();
        BeanUtils.copyProperties(markingPaperVO,markingPaperDTO);
        List<MarkingAnswerDTO> markingAnswerDTOS = CommonUtils.convertList(markingPaperVO.getMarkingAnswerVOList(), MarkingAnswerDTO.class);
        markingPaperDTO.setMarkingAnswerDTOList(markingAnswerDTOS);
        if (gradeService.markingPaper(markingPaperDTO)){
            return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,true);
        }
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,false);
    }

    /**
     * 获取答题情况
     * @param commonRequest
     * @return
     */
    @MethodEnhancer
    @RequestMapping(value = "getPaperAnswer")
    public CommonResponse<List> getPaperAnswer(@RequestBody CommonRequest<Long> commonRequest){
        Long examRecordId = commonRequest.getData();
        List<MyAnswerDTO> myAnswerDTOS = gradeService.getMyAnswer(examRecordId);
        List<MyAnswerVO> myAnswerVOS = CommonUtils.convertList(myAnswerDTOS, MyAnswerVO.class);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,myAnswerVOS);
    }

    private void setVoStatus(ExamGradeRecordTableDataVO tableDataVO,ExamGradeRecordTableDataDTO tableDataDTO){
       if (tableDataDTO.getStatus()!=null){
           if (tableDataDTO.getStatus()==1)
               tableDataVO.setStatus("已批阅");
           else if (tableDataDTO.getStatus()==0)
               tableDataVO.setStatus("未批阅");
           else
               tableDataVO.setStatus("阅卷过期");
       }
    }

    private String getPaperName(Long id,CommonRequest commonRequest){
        if (id!=null) {
            CommonRequest<Long> request = new CommonRequest<>();
            request.setToken(commonRequest.getToken());
            request.setData(id);
            request.setVersion(commonRequest.getVersion());
            return RPCUtils.parseResponse(paperApi.queryPaperNameByPaperId(request),String.class,RPCUtils.PAPER);
        }
        return null;
    }

}

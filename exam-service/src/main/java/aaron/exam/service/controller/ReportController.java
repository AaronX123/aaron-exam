package aaron.exam.service.controller;

import aaron.common.data.common.CommonRequest;
import aaron.common.data.common.CommonResponse;
import aaron.common.data.common.CommonState;
import aaron.common.logging.annotation.MethodEnhancer;
import aaron.common.utils.CommonUtils;
import aaron.exam.service.common.utils.DateFormatUtil;
import aaron.exam.service.pojo.DTO.report.ExamDetailQueryFormDTO;
import aaron.exam.service.pojo.DTO.report.ExamReportRecordDetailTableDataDTO;
import aaron.exam.service.pojo.DTO.report.ExamReportRecordExamTableDataDTO;
import aaron.exam.service.pojo.DTO.report.ExamReportRecordQueryFormDTO;
import aaron.exam.service.pojo.VO.report.ExamDetailQueryFormVO;
import aaron.exam.service.pojo.VO.report.ExamReportRecordDetailTableDataVO;
import aaron.exam.service.pojo.VO.report.ExamReportRecordExamTableDataVO;
import aaron.exam.service.pojo.VO.report.ExamReportRecordQueryFormVO;
import aaron.exam.service.service.ReportService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("report")
public class ReportController {
    private final static Integer PAGE_SIZE = 8;
    private final static double RANK_A = 0.9;
    private final static double RANK_B = 0.8;
    private final static double RANK_C = 0.6;

    @Autowired
    CommonState state;

    @Autowired
    ReportService reportService;


    @MethodEnhancer
    @RequestMapping(value = "query",method = RequestMethod.POST)
    public CommonResponse<Map> query(@RequestBody CommonRequest<ExamReportRecordQueryFormVO> commonRequest){
        ExamReportRecordQueryFormVO queryFormVO = commonRequest.getData();
        ExamReportRecordQueryFormDTO queryFormDTO = CommonUtils.copyProperties(queryFormVO,ExamReportRecordQueryFormDTO.class);

        if (queryFormVO.getExamTimeRange()!=null && queryFormVO.getExamTimeRange().size()!=0) {
            queryFormDTO.setStartTime(queryFormVO.getExamTimeRange().get(0));
            queryFormDTO.setEndTime(queryFormVO.getExamTimeRange().get(1));
        }
        Page p = PageHelper.startPage(commonRequest.getData().getCurrentPage(),PAGE_SIZE);
        List<ExamReportRecordExamTableDataDTO> tableDataDTOS = reportService.query(queryFormDTO);
        List<ExamReportRecordExamTableDataVO> tableDataVOS = new ArrayList<>();
        for (ExamReportRecordExamTableDataDTO tableDataDTO : tableDataDTOS) {
            ExamReportRecordExamTableDataVO vo = CommonUtils.copyProperties(tableDataDTO,ExamReportRecordExamTableDataVO.class);
            vo.setEndTime(DateFormatUtil.format(tableDataDTO.getEndTime()));
            tableDataVOS.add(vo);
        }
        PageInfo<ExamReportRecordExamTableDataVO> pageInfo = new PageInfo<>(tableDataVOS);
        Map<String,Object> map = new HashMap<>();
        map.put("total",p.getTotal());
        map.put("pageInfo",pageInfo);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,map);
    }

    @MethodEnhancer
    @RequestMapping(value = "querydetail",method = RequestMethod.POST)
    public CommonResponse<Map> queryDetail(@RequestBody CommonRequest<ExamDetailQueryFormVO> commonRequest){
        int rank = 0;
        ExamDetailQueryFormVO  queryFormVO = commonRequest.getData();
        ExamDetailQueryFormDTO queryFormDTO = CommonUtils.copyProperties(queryFormVO,ExamDetailQueryFormDTO.class);
        Page p = PageHelper.startPage(commonRequest.getData().getCurrentPage(),10);
        List<ExamReportRecordDetailTableDataDTO> tableDataDTOS = reportService.queryDetail(queryFormDTO);
        // 查询该考试的试卷满分是多少
        Double score = reportService.findMaxScore(queryFormVO.getId());
        List<ExamReportRecordDetailTableDataVO> tableDataVOS = new ArrayList<>();
        if (tableDataDTOS!=null && tableDataDTOS.size()!=0){
            for (ExamReportRecordDetailTableDataDTO tableDataDTO : tableDataDTOS) {
                ExamReportRecordDetailTableDataVO vo = CommonUtils.copyProperties(tableDataDTO,ExamReportRecordDetailTableDataVO.class);
                vo.setAbilityLabel(getLabel(tableDataDTO,score));
                vo.setExamCostTime(getCostTime(tableDataDTO));
                vo.setRanking(++rank + (queryFormVO.getCurrentPage()-1) * PAGE_SIZE);
                tableDataVOS.add(vo);
            }
        }
        PageInfo<ExamReportRecordDetailTableDataVO> pageInfo = new PageInfo<>(tableDataVOS);
        Map<String,Object> map = new HashMap<>();
        map.put("total",p.getTotal());
        map.put("pageInfo",pageInfo);
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,map);
    }

    /**
     * 根据试卷总分的百分比计算等级
     * @param dto
     * @return
     */
    private String getLabel(ExamReportRecordDetailTableDataDTO dto, Double score){
        if (dto.getScore()!=null){
            if (dto.getScore() >= (RANK_A * score))
                return "A";
            else if (dto.getScore() >= (RANK_B * score))
                return "B";
            else if (dto.getScore() >= (RANK_C * score))
                return "C";
            else
                return "D";
        }
        return null;
    }

    private String getCostTime(ExamReportRecordDetailTableDataDTO dto){
        if (dto.getActualStartTime()!=null && dto.getActualEndTime()!=null){
            Long costTime = (dto.getActualEndTime().getTime() - dto.getActualStartTime().getTime()) / (1000 * 60);
            return costTime.toString()+"分钟";
        }
        return null;
    }
}

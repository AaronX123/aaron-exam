package aaron.exam.service.api.impl;

import aaron.common.data.common.CommonResponse;
import aaron.common.data.common.CommonState;
import aaron.common.utils.CommonUtils;
import aaron.exam.service.dao.mapper.ExamPublishRecordMapper;
import aaron.exam.service.pojo.model.ExamPublishRecord;
import api.ExamApi;
import constant.ApiConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-04-24
 */
@RestController
public class ExamApiImpl implements ExamApi {
    @Resource
    ExamPublishRecordMapper examPublishRecordMapper;

    @Autowired
    CommonState state;

    /**
     * 试卷服务用来判断是否可以删除
     *
     * @param request
     * @return
     */
    @PostMapping(ApiConstant.CHECK_EDITABLE)
    @Override
    public CommonResponse<Boolean> checkEditable(@RequestBody Long request) {
        List<ExamPublishRecord> record = examPublishRecordMapper.listByPaperId(request);
        if (CommonUtils.isEmpty(record)){
            return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,true);
        }
        return new CommonResponse<>(state.SUCCESS,state.SUCCESS_MSG,false);
    }
}

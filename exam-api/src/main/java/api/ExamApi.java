package api;

import aaron.common.data.common.CommonResponse;
import constant.ApiConstant;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-04-24
 */
public interface ExamApi {
    /**
     * 试卷服务用来判断是否可以删除
     * @param request
     * @return
     */
    @PostMapping(ApiConstant.CHECK_EDITABLE)
    CommonResponse<Boolean> checkEditable(@RequestBody Long request);
}

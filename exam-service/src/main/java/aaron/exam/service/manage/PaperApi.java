package aaron.exam.service.manage;

import aaron.common.data.common.CommonRequest;
import aaron.common.data.common.CommonResponse;
import aaron.paper.api.constant.ApiConstant;
import aaron.paper.api.dto.FuzzySearch;
import aaron.paper.api.dto.PaperDetail;
import aaron.paper.api.dto.PaperIdWithName;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-04-24
 */
@FeignClient(ApiConstant.SERVER_NAME)
public interface PaperApi {
    @PostMapping({"/paper/paper/info/publish/paper"})
    CommonResponse<Boolean> publishPaper(CommonRequest<Long> paperId);

    @GetMapping({"/paper/paper/info/list/paper"})
    CommonResponse<List<PaperIdWithName>> listPaper();

    @PostMapping({"/paper/paper/info/fuzzy/search"})
    CommonResponse<List<PaperIdWithName>> fuzzySearchByPaperName(CommonRequest<FuzzySearch> request);

    @PostMapping({"/paper/paper/info/query/detail"})
    CommonResponse<PaperDetail> queryDetailByPaperId(CommonRequest<Long> request);

    @PostMapping({"/paper/paper/info/query/published/time"})
    CommonResponse<Integer> queryPublishedTimesByPaperId(CommonRequest<Long> request);

    @PostMapping({"/paper/paper/info/query/paper/name"})
    CommonResponse<String> queryPaperNameByPaperId(CommonRequest<Long> request);

    @PostMapping("/paper/paper/info/query/paper/score")
    CommonResponse queryPaperScore(CommonRequest<Long> request);
}

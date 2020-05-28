package aaron.exam.service.manage;

import aaron.common.data.common.CommonRequest;
import aaron.common.data.common.CommonResponse;
import aaron.user.api.constant.ApiConstant;
import aaron.user.api.dto.CompanyAndUserVo;
import aaron.user.api.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author xiaoyouming
 * @version 1.0
 * @since 2020-04-24
 */
@FeignClient(ApiConstant.SERVICE_NAME)
public interface UserApi {
    @PostMapping({"/user/get/user/name"})
    CommonResponse<CompanyAndUserVo> getUserInfo(CommonRequest<List<Long>> request);

    @PostMapping({"/user/get/company/name/by/id"})
    CommonResponse<String> getUserNameById(CommonRequest<Long> request);

    @PostMapping({"/user/get/scoring/officer"})
    CommonResponse<List<UserDto>> queryScoringOfficer(CommonRequest<UserDto> request);

    @PostMapping({"/user/get/id/by/name"})
    CommonResponse<Long> getUserIdByName(CommonRequest<String> request);

    @PostMapping({"/user/get/company/name"})
    CommonResponse<String> getCompanyById(CommonRequest<Long> request);
}

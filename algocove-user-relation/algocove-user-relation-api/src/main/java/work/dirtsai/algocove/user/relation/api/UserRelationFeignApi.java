package work.dirtsai.algocove.user.relation.api;

import jakarta.annotation.Resource;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import work.dirtsai.algocove.user.relation.constant.ApiConstants;
import work.dirtsai.algocove.user.relation.model.dto.FansPageReqDTO;
import work.dirtsai.algocove.user.relation.model.dto.FansPageRspDTO;
import work.dirtsai.framework.common.response.Response;

import java.util.List;

@FeignClient(name = ApiConstants.SERVICE_NAME)
public interface UserRelationFeignApi{

    /**
     * 分页查询粉丝
     */
    @PostMapping("/relation/fans/page")
    Response<FansPageRspDTO> getFansPage(@RequestBody FansPageReqDTO fansPageReqDTO);
}
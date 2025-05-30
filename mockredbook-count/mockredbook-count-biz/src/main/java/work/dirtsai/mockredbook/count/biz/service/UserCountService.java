package work.dirtsai.mockredbook.count.biz.service;


import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.count.dto.FindUserCountByIdReqDTO;
import work.dirtsai.mockredbook.count.dto.FindUserCountByIdRspDTO;

/**
 * @author: czl
 * @date: 2024/4/7 15:41
 * @version: v1.0.0
 * @description: 用户计数业务
 **/
public interface UserCountService {

    Response<FindUserCountByIdRspDTO> findUserCountData(FindUserCountByIdReqDTO findUserCountByIdReqDTO);
}

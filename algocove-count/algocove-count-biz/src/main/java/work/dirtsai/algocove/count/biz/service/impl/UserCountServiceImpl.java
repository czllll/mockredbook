package work.dirtsai.algocove.count.biz.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.algocove.count.biz.domain.dataobject.UserCountDO;
import work.dirtsai.algocove.count.biz.domain.mapper.UserCountDOMapper;
import work.dirtsai.algocove.count.biz.service.UserCountService;
import work.dirtsai.algocove.count.dto.FindUserCountByIdReqDTO;
import work.dirtsai.algocove.count.dto.FindUserCountByIdRspDTO;

import java.util.Objects;


/**
 * @author: czl
 * @date: 2024/4/7 15:41
 * @version: v1.0.0
 * @description: 用户计数业务
 **/
@Service
@Slf4j
public class UserCountServiceImpl implements UserCountService {

    @Resource
    private UserCountDOMapper userCountDOMapper;

    @Override
    public Response<FindUserCountByIdRspDTO> findUserCountData(FindUserCountByIdReqDTO findUserCountByIdReqDTO) {
        Long userId = findUserCountByIdReqDTO.getUserId();

        FindUserCountByIdRspDTO findUserCountByIdRspDTO = FindUserCountByIdRspDTO.builder()
                .userId(userId)
                .build();

        UserCountDO userCountDO = userCountDOMapper.selectByUserId(userId);

        if (Objects.nonNull(userCountDO)) {
            findUserCountByIdRspDTO.setCollectTotal(userCountDO.getCollectTotal());
            findUserCountByIdRspDTO.setFansTotal(userCountDO.getFansTotal());
            findUserCountByIdRspDTO.setNoteTotal(userCountDO.getNoteTotal());
            findUserCountByIdRspDTO.setFollowingTotal(userCountDO.getFollowingTotal());
            findUserCountByIdRspDTO.setLikeTotal(userCountDO.getLikeTotal());
        }

        return Response.success(findUserCountByIdRspDTO);
    }
}

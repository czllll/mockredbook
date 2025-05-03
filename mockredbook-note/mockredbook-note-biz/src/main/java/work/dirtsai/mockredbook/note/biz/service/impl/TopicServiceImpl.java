package work.dirtsai.mockredbook.note.biz.service.impl;

import cn.hutool.core.collection.CollUtil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.note.biz.domain.dataobject.TopicDO;
import work.dirtsai.mockredbook.note.biz.domain.mapper.TopicDOMapper;
import work.dirtsai.mockredbook.note.biz.model.vo.FindTopicListReqVO;
import work.dirtsai.mockredbook.note.biz.model.vo.FindTopicRspVO;
import work.dirtsai.mockredbook.note.biz.service.TopicService;

import java.util.List;

/**
 * @author czl$
 * @date 2025/4/21$
 */

@Service
public class TopicServiceImpl implements TopicService {
    @Resource
    private TopicDOMapper topicDOMapper;

    @Override
    public Response<List<FindTopicRspVO>> findTopicList(FindTopicListReqVO findTopicListReqVO) {
        String keyword = findTopicListReqVO.getKeyword();

        List<TopicDO> topicDOS = topicDOMapper.selectByLikeName(keyword);

        List<FindTopicRspVO> findTopicRspVOS = null;
        if (CollUtil.isNotEmpty(topicDOS)) {
            findTopicRspVOS = topicDOS.stream()
                    .map(topicDO -> FindTopicRspVO.builder()
                            .id(topicDO.getId())
                            .name(topicDO.getName())
                            .build())
                    .toList();
        }

        return Response.success(findTopicRspVOS);
    }
}

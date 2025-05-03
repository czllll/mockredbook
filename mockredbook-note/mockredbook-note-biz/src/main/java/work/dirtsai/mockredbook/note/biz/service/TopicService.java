package work.dirtsai.mockredbook.note.biz.service;

import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.note.biz.model.vo.FindTopicListReqVO;
import work.dirtsai.mockredbook.note.biz.model.vo.FindTopicRspVO;

import java.util.List;

/**
 * @author czl$
 * @date 2025/4/21$
 */

public interface TopicService {
    Response<List<FindTopicRspVO>> findTopicList(FindTopicListReqVO findTopicListReqVO);
}

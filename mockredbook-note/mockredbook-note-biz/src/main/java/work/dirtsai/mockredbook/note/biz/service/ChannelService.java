package work.dirtsai.mockredbook.note.biz.service;

import work.dirtsai.framework.common.response.Response;
import work.dirtsai.mockredbook.note.biz.model.vo.FindChannelRspVO;

import java.util.List;

/**
 * @author czl$
 * @date 2025/4/21$
 */

public interface ChannelService {

    /**
     * 查询所有频道
     * @return
     */
    Response<List<FindChannelRspVO>> findChannelList();
}

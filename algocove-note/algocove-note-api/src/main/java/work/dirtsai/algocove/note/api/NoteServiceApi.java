package work.dirtsai.algocove.note.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import work.dirtsai.algocove.note.biz.model.vo.FindDiscoverNoteRspVO;
import work.dirtsai.algocove.note.constant.ApiConstants;
import work.dirtsai.algocove.note.model.dto.NotePageReqDTO;
import work.dirtsai.framework.common.response.PageResponse;
import work.dirtsai.framework.common.response.Response;

import java.util.List;

@FeignClient(name = ApiConstants.SERVICE_NAME)
public interface NoteServiceApi {

    @PostMapping("/note/queryByUserIds")
    List<FindDiscoverNoteRspVO> getNotesByUserIds(@RequestBody List<Long> noteIdList);

    @PostMapping("/note/queryByUserIds/debug")
    Object debugGetNotesByUserIds(@RequestBody List<Long> noteIdList);
}

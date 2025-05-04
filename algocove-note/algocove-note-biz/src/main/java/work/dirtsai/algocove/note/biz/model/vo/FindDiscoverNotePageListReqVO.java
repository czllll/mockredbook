package work.dirtsai.algocove.note.biz.model.vo;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author czl$
 * @date 2025/4/21$
 * @description 查询发现页笔记列表入参
 */

@Data
public class FindDiscoverNotePageListReqVO {
    // 频道id
    private Long channelId;

    @NotNull(message = "页码不能为空")
    private Integer pageNo = 1;
}

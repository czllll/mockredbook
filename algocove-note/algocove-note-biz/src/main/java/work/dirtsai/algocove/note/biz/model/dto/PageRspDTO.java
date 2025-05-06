package work.dirtsai.algocove.note.biz.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author czl$
 * @date 2025/5/5$
 */

@Data
@Builder
public class PageRspDTO<T> {
    private List<T> list;        // 当前页的数据
    private Long nextCursor;     // 下一页的游标（分页锚点）
    private Boolean hasMore;     // 是否还有下一页
}

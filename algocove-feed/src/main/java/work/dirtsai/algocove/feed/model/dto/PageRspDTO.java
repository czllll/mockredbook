package work.dirtsai.algocove.feed.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author czl$
 * @date 2025/5/5$
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageRspDTO<T> {

    /** 数据列表 */
    private List<T> list;

    /** 下一页游标（null 表示没有更多） */
    private Long nextCursor;

    /** 是否还有下一页 */
    private Boolean hasMore;
}
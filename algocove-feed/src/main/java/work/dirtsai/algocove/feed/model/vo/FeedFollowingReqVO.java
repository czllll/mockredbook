package work.dirtsai.algocove.feed.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author czl$
 * @date 2025/5/4$
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedFollowingReqVO {
    /**
     * 用户ID
     */
    private Long xiaohashuId;

    /**
     * 游标
     */
    private Long cursor;

    /**
     * 条数限制, 默认20条
     */
    private int limit;

}

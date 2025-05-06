package work.dirtsai.algocove.user.relation.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author czl$
 * @date 2025/5/4$
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FansPageReqDTO {
    private Long creatorId;   // 作者 ID（被关注的人）
    private Long cursor;      // 游标（上页最后一个 followerId）
    private Integer limit;    // 每页条数
}
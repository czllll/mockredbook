package work.dirtsai.algocove.feed.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author czl$
 * @date 2025/5/4$
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FeedFollowingMqDTO {
    private Long noteId;
    private Long creatorId;
    private LocalDateTime createTime;
}

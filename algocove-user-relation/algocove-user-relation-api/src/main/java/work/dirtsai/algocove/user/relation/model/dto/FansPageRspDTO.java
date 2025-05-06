package work.dirtsai.algocove.user.relation.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author czl$
 * @date 2025/5/4$
 */

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class FansPageRspDTO {
    private List<Long> fansIds;
    private Long nextCursor;
    private Boolean hasMore;


}
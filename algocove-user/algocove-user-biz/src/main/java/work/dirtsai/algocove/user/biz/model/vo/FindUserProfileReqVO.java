package work.dirtsai.algocove.user.biz.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author czl$
 * @date 2025/4/21$
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindUserProfileReqVO {

    /**
     * 用户 ID
     */
    private Long userId;

}

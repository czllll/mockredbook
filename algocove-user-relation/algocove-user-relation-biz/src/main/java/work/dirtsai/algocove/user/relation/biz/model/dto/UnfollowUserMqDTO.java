package work.dirtsai.algocove.user.relation.biz.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;


import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UnfollowUserMqDTO {

    private Long userId;

    private Long unfollowUserId;

    private LocalDateTime createTime;
}
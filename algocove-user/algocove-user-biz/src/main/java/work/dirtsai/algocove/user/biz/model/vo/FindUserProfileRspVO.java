package work.dirtsai.algocove.user.biz.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author czl$
 * @date 2025/4/21$
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindUserProfileRspVO {

    /**
     * 用户 ID
     */
    private Long userId;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 小哈书 ID
     */
    private String xiaohashuId;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 岁数
     */
    private Integer age;

    /**
     * 生日
     */
    private LocalDate birthday;

    /**
     * 个人介绍
     */
    private String introduction;

    /**
     * 关注数
     */
    private String followingTotal = "0";

    /**
     * 粉丝数
     */
    private String fansTotal = "0";

    /**
     * 点赞与收藏总数
     */
    private String likeAndCollectTotal = "0";
}


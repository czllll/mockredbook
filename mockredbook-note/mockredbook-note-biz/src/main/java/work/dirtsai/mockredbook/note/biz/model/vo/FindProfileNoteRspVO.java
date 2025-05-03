package work.dirtsai.mockredbook.note.biz.model.vo;

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
public class FindProfileNoteRspVO {
    /**
     * 笔记 ID
     */
    private String id;

    /**
     * 笔记类型
     */
    private Integer type;

    /**
     * 封面图
     */
    private String cover;

    /**
     * 视频连接
     */
    private String videoUri;

    /**
     * 标题
     */
    private String title;

    /**
     * 发布者用户 ID
     */
    private Long creatorId;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 被点赞量
     */
    private String likeTotal;
}

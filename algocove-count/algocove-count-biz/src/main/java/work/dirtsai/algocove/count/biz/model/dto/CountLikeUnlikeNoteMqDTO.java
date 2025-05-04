package work.dirtsai.algocove.count.biz.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @description: 点赞、取消点赞笔记
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CountLikeUnlikeNoteMqDTO {

    private Long userId;

    private Long noteId;

    /**
     * 0: 取消点赞， 1：点赞
     */
    private Integer type;


    /**
     * 笔记发布者 ID
     */
    private Long noteCreatorId;


    private LocalDateTime createTime;
}

package work.dirtsai.mockredbook.data.align.constant;

public class RedisKeyConstants {

    /**
     * 布隆过滤器：日增量变更数据，用户笔记点赞，取消点赞 前缀
     */
    public static final String BLOOM_TODAY_NOTE_LIKE_LIST_KEY = "bloom:dataAlign:note:likes:";


    /**
     * 构建完整的布隆过滤器：日增量变更数据，用户笔记点赞，取消点赞 KEY
     * @param date
     * @return
     */
    public static String buildBloomUserNoteLikeListKey(String date) {
        return BLOOM_TODAY_NOTE_LIKE_LIST_KEY + date;
    }

}
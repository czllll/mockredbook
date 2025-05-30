package work.dirtsai.mockredbook.note.biz.consumer;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import work.dirtsai.mockredbook.note.biz.constant.MQConstants;
import work.dirtsai.mockredbook.note.biz.service.NoteService;

@Component
@Slf4j
@RocketMQMessageListener(consumerGroup = "mockbook_group_" + MQConstants.TOPIC_DELETE_NOTE_LOCAL_CACHE, // Group
        topic = MQConstants.TOPIC_DELETE_NOTE_LOCAL_CACHE, // 消费的主题 Topic
        messageModel = MessageModel.BROADCASTING) // 广播模式
public class DeleteNoteLocalCacheConsumer implements RocketMQListener<String> {

    @Resource
    private NoteService noteService;

    @Override
    public void onMessage(String body) {
        Long noteId = Long.valueOf(body);
        noteService.deleteNoteLocalCache(noteId);
        log.info("## 消费者消费成功, noteId: {}", noteId);
    }

}
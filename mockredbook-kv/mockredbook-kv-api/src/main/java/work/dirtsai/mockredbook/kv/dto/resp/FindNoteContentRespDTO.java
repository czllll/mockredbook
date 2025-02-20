package work.dirtsai.mockredbook.kv.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindNoteContentRespDTO {

    /**
     * 笔记内容 UUID
     */
    private UUID uuid;

    /**
     * 笔记内容
     */
    private String content;

}

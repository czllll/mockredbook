package work.dirtsai.algocove.note.biz.rpc;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import work.dirtsai.algocove.distributed.id.generator.api.DistributedIdGeneratorFeignApi;

@Component
public class DistributedIdGeneratorRpcService {

    @Resource
    private DistributedIdGeneratorFeignApi distributedIdGeneratorFeignApi;

    /**
     * 生成雪花算法 ID
     *
     * @return
     */
    public String getSnowflakeId() {
        return distributedIdGeneratorFeignApi.getSnowflakeId("test");
    }

}
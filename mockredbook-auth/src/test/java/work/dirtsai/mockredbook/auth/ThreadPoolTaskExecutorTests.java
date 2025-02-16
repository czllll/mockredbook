package work.dirtsai.mockredbook.auth;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootTest
@Slf4j
public class ThreadPoolTaskExecutorTests {
    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Test
    void testSubmit() {
        threadPoolTaskExecutor.submit(() -> log.info("这是一个异步线程"));
    }
}

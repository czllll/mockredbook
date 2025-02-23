package work.dirtsai.mockredbook.count.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("work.dirtsai.mockredbook.count.biz.domain.mapper")
public class MockredbookCountBizApplication {
    public static void main(String[] args) {
        SpringApplication.run(MockredbookCountBizApplication.class, args);
    }
}

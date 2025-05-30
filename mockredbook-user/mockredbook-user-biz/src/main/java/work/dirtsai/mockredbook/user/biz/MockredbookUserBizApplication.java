package work.dirtsai.mockredbook.user.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "work.dirtsai.mockredbook")
@SpringBootApplication
@MapperScan("work.dirtsai.mockredbook.user.biz.domain.mapper")
public class MockredbookUserBizApplication {
    public static void main(String[] args) {
        SpringApplication.run(MockredbookUserBizApplication.class, args);
    }
}

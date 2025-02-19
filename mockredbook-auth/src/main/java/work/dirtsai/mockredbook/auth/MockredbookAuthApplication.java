package work.dirtsai.mockredbook.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("work.dirtsai.mockredbook.auth.domain.mapper")
@EnableFeignClients(basePackages = "work.dirtsai.mockredbook")
public class MockredbookAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MockredbookAuthApplication.class, args);
    }

}

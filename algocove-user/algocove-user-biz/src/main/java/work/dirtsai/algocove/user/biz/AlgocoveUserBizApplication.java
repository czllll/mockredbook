package work.dirtsai.algocove.user.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "work.dirtsai.algocove")
@SpringBootApplication
@MapperScan("work.dirtsai.algocove.user.biz.domain.mapper")
public class AlgocoveUserBizApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlgocoveUserBizApplication.class, args);
    }
}

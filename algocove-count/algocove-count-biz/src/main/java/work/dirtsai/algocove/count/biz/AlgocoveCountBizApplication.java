package work.dirtsai.algocove.count.biz;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("work.dirtsai.algocove.count.biz.domain.mapper")
public class AlgocoveCountBizApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlgocoveCountBizApplication.class, args);
    }
}

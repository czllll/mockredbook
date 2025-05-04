package work.dirtsai.algocove.data.align;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("work.dirtsai.algocove.data.align.domain.mapper")
public class AlgocoveDataAlignApplication {
    public static void main(String[] args) {
        SpringApplication.run(AlgocoveDataAlignApplication.class, args);
    }
}

package work.dirtsai.mockredbook.data.align;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("work.dirtsai.mockredbook.data.align.domain.mapper")
public class MockredbookDataAlignApplication {
    public static void main(String[] args) {
        SpringApplication.run(MockredbookDataAlignApplication.class, args);
    }
}

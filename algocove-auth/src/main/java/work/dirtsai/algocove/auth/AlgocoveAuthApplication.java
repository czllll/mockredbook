package work.dirtsai.algocove.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "work.dirtsai.algocove")
public class  AlgocoveAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlgocoveAuthApplication.class, args);
    }

}

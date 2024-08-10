package kr.junction.delavery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DelaveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DelaveryApplication.class, args);
    }

}

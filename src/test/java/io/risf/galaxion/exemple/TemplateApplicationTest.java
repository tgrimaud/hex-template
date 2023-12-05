package io.risf.galaxion.exemple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class TemplateApplicationTest {

    private static Logger LOG = LoggerFactory
            .getLogger(TemplateApplicationTest.class);

    public static void main(String[] args) {
        SpringApplication.run(TemplateApplicationTest.class, args);
    }
}

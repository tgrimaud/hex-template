package io.risf.galaxion.exemple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class TemplateApplication {

    private static Logger LOG = LoggerFactory
            .getLogger(TemplateApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(TemplateApplication.class, args);
        initApplication(context);
    }

    private static void initApplication(ConfigurableApplicationContext context){
        LOG.info("Init Application");

        //Manual Injection
       // DomainRegistry.accountDomainService().accountEligibilityPolicy(new MajorAccountEligibilibittyPolicy());
        //Using a mix of SpringBoot injection and Manual
        //context.getBean(AccountPersistenceAdapter.class).accountRepository(InMemoryAccountRepository.getInstance());

        //You can set here all your implementation without using Spring Injection
        //So it could be more dynamic
    }
}

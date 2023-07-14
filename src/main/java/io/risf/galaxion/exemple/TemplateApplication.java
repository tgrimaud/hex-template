package io.risf.galaxion.exemple;

import io.risf.galaxion.exemple.accountmanagement.adapter.out.persistence.AccountPersistenceAdapter;
import io.risf.galaxion.exemple.accountmanagement.adapter.out.persistence.InMemoryAccountRepository;
import io.risf.galaxion.exemple.accountmanagement.adapter.out.queue.AccountQueueEventAdapter;
import io.risf.galaxion.exemple.accountmanagement.domain.DomainRegistry;
import io.risf.galaxion.exemple.accountmanagement.domain.model.MajorAccountEligibilibittyPolicy;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.in.event.SubscriptionAccountEventAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


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
        DomainRegistry.accountEventPublisher().addAccountCreatedHandler(new AccountQueueEventAdapter());
        DomainRegistry.accountEventPublisher().addAccountCreatedHandler(context.getBean(SubscriptionAccountEventAdapter.class));
        DomainRegistry.accountDomainService().accountEligibilityPolicy(new MajorAccountEligibilibittyPolicy());
        //Using a mix of SpringBoot injection and Manual
        context.getBean(AccountPersistenceAdapter.class).accountRepository(InMemoryAccountRepository.getInstance());

        //You can set here all your implementation without using Spring Injection
        //So it could be more dynamic
    }
}

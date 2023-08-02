package io.risf.galaxion.exemple.accountmanagement.adapter.out.queue;

import io.risf.galaxion.exemple.accountmanagement.application.port.event.AccountCreatedHandler;
import io.risf.galaxion.exemple.accountmanagement.domain.model.AccountCreated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AccountQueueEventAdapter implements AccountCreatedHandler {
    private static Logger Logger = LoggerFactory
            .getLogger(AccountQueueEventAdapter.class);

    //@EventListener
    public void handleAccountCreated(AccountCreated event) {
        Logger.info("Event Received");
        /* Call Rabbit Producer */
    }
}

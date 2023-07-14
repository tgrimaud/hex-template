package io.risf.galaxion.exemple.subscriptionmanagement.application.service;

import io.risf.galaxion.exemple.accountmanagement.adapter.out.queue.AccountQueueEventAdapter;
import io.risf.galaxion.exemple.subscriptionmanagement.application.port.in.CreateSubscriptionCommand;
import io.risf.galaxion.exemple.subscriptionmanagement.application.port.in.CreateSubscriptionUseCase;
import lombok.RequiredArgsConstructor;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateSubscriptionApplicationService implements CreateSubscriptionUseCase {

    private static org.slf4j.Logger Logger = LoggerFactory
            .getLogger(CreateSubscriptionApplicationService.class);

    public void createSubscription(CreateSubscriptionCommand command) {
        Logger.info("Create Sub for Account with Id {}", command.AccountId());

    }
}

package io.risf.galaxion.exemple.accountmanagement.domain.model;

import io.risf.galaxion.exemple.accountmanagement.application.port.event.AccountCreatedHandler;
import io.risf.galaxion.exemple.accountmanagement.application.port.event.AccountEventPublisher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountEventPublisherTest {
    @Test
    void testAccountPublisherWithHandler() {
        final AccountCreated[] receivedAccountCreated = new AccountCreated[1];

        Account account = new AccountMother()
                .randomAccount()
                .build();
        AccountCreated accountCreated = AccountEventFactory.createAccountCreatedEventV1(account);
        AccountEventPublisher accountEventPublisher = new AccountEventPublisher();
        accountEventPublisher.addAccountCreatedHandler(new AccountCreatedHandler() {
            @Override
            public void handleAccountCreated(AccountCreated event) {
                receivedAccountCreated[0] = event;
            }
        });
        accountEventPublisher.publishAccountCreatedEvent(accountCreated);
        Assertions.assertEquals(receivedAccountCreated[0], accountCreated);
    }

    @Test
    void testAccountPublisherWithoutHandler() {
        final AccountCreated[] receivedAccountCreated = new AccountCreated[1];
        AccountEventPublisher accountEventPublisher = new AccountEventPublisher();

        Account account = new AccountMother()
                .randomAccount()
                .build();
        AccountCreated accountCreated = AccountEventFactory.createAccountCreatedEventV1(account);

        accountEventPublisher.publishAccountCreatedEvent(accountCreated);
    }
}

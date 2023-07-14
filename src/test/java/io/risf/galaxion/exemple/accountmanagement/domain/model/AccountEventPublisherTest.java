package io.risf.galaxion.exemple.accountmanagement.domain.model;

import io.risf.galaxion.exemple.accountmanagement.application.port.event.AccountCreatedHandler;
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

        AccountEventPublisher.getInstance().addAccountCreatedHandler(new AccountCreatedHandler() {
            @Override
            public void handleAccountCreated(AccountCreated event) {
                receivedAccountCreated[0] = event;
            }
        });
        AccountEventPublisher.getInstance().publishAccountCreatedEvent(accountCreated);
        Assertions.assertEquals(receivedAccountCreated[0], accountCreated);
    }

    @Test
    void testAccountPublisherWithoutHandler() {
        final AccountCreated[] receivedAccountCreated = new AccountCreated[1];

        Account account = new AccountMother()
                .randomAccount()
                .build();
        AccountCreated accountCreated = AccountEventFactory.createAccountCreatedEventV1(account);

        AccountEventPublisher.getInstance().publishAccountCreatedEvent(accountCreated);
    }
}

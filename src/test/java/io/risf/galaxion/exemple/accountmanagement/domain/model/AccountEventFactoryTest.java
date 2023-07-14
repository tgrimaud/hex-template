package io.risf.galaxion.exemple.accountmanagement.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class AccountEventFactoryTest {
    @Test
    void testEventCreationOccurredAt_testDateAfter() throws InterruptedException {
        Date beforeCreation = new Date();
        Thread.sleep(10);
        Account account = new AccountMother()
                .withFirstName("Tom")
                .withLastName("Bombadil")
                .withEmail("tom.bombadil@lotr.com")
                .withAge(10)
                .build();

        AccountCreated accountCreated = AccountEventFactory.createAccountCreatedEventV1(account);
        Assertions.assertTrue(accountCreated.occurredAt().after(beforeCreation));
    }

    @Test
    void testEventCreationOccurredAt_testDateBefore() throws InterruptedException {

        Account account = new AccountMother()
                .randomAccount()
                .build();
        AccountCreated accountCreated = AccountEventFactory.createAccountCreatedEventV1(account);
        Thread.sleep(10);
        Date afterCreation = new Date();
        Assertions.assertTrue(accountCreated.occurredAt().before(afterCreation));
    }

    @Test
    void testAccountCreatedVersion() {
        Account account = new AccountMother()
                .randomAccount()
                .build();
        AccountCreated accountCreated = AccountEventFactory.createAccountCreatedEventV1(account);
        Assertions.assertEquals(accountCreated.version() ,"1");
    }

}

package io.risf.galaxion.exemple.accountmanagement.domain.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountMotherTest {

    @Test
    void minorAccountTest() {
        Account minorAccount = new AccountMother().minorAccount()
                .build();
        Assertions.assertTrue(minorAccount.getAge() < 18);
    }

    @Test
    void majorAccountTest() {
        Account majorAccount = new AccountMother().majorAccount()
                .build();
        Assertions.assertTrue(majorAccount.getAge() >= 18);
    }
}

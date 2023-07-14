package io.risf.galaxion.exemple.accountmanagement.domain.service;
import io.risf.galaxion.exemple.accountmanagement.domain.model.AccountMother;
import io.risf.galaxion.exemple.accountmanagement.domain.model.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountDomainServiceTest {

    @Test
    void nonEligibleAccountTest() {
        Account nonEligibleAccount = new AccountMother().minorAccount()
                .withFirstName("Tom")
                .withLastName("Bombadil")
                .withEmail("tom.bombadil@lotr.com")
                .build();
        Assertions.assertFalse(AccountDomainService.getInstance().isAccountEligibleForCreation(nonEligibleAccount));
    }

    @Test
    void eligibleAccountTest() {
        Account nonEligibleAccount = new AccountMother().majorAccount()
                .withFirstName("Tom")
                .withLastName("Bombadil")
                .withEmail("tom.bombadil@lotr.com")
                .build();
        Assertions.assertTrue(AccountDomainService.getInstance().isAccountEligibleForCreation(nonEligibleAccount));
    }
}

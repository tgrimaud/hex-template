package io.risf.galaxion.exemple.accountmanagement.domain.service;
import io.risf.galaxion.exemple.accountmanagement.domain.model.AccountEligibilityPolicy;
import io.risf.galaxion.exemple.accountmanagement.domain.model.AccountMother;
import io.risf.galaxion.exemple.accountmanagement.domain.model.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountDomainServiceTest {

    @Test
    void nonEligibleAccountTest() {
        AccountDomainService accountDomainService = new AccountDomainService();
        accountDomainService.accountEligibilityPolicy(new AccountEligibilityPolicy() {
            @Override
            public boolean isAccountEligible(Account account) {
                return false;
            }
        });

        Account nonEligibleAccount = new AccountMother().randomAccount()
                .build();
        Assertions.assertFalse(accountDomainService.isAccountEligibleForCreation(nonEligibleAccount));
    }

    @Test
    void eligibleAccountTest() {
        AccountDomainService accountDomainService = new AccountDomainService();
        accountDomainService.accountEligibilityPolicy(new AccountEligibilityPolicy() {
            @Override
            public boolean isAccountEligible(Account account) {
                return true;
            }
        });

        Account nonEligibleAccount = new AccountMother().randomAccount()
                .build();
        Assertions.assertTrue(accountDomainService.isAccountEligibleForCreation(nonEligibleAccount));
    }
}

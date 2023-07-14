package io.risf.galaxion.exemple.accountmanagement.domain.service;
import io.risf.galaxion.exemple.accountmanagement.domain.model.AccountEligibilityPolicy;
import io.risf.galaxion.exemple.accountmanagement.domain.model.AccountMother;
import io.risf.galaxion.exemple.accountmanagement.domain.model.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountDomainServiceTest {

    @Test
    void nonEligibleAccountTest() {
        AccountDomainService.getInstance().accountEligibilityPolicy(new AccountEligibilityPolicy() {
            @Override
            public boolean isAccountEligible(Account account) {
                return false;
            }
        });

        Account nonEligibleAccount = new AccountMother().randomAccount()
                .build();
        Assertions.assertFalse(AccountDomainService.getInstance().isAccountEligibleForCreation(nonEligibleAccount));
    }

    @Test
    void eligibleAccountTest() {
        AccountDomainService.getInstance().accountEligibilityPolicy(new AccountEligibilityPolicy() {
            @Override
            public boolean isAccountEligible(Account account) {
                return true;
            }
        });

        Account nonEligibleAccount = new AccountMother().randomAccount()
                .build();
        Assertions.assertTrue(AccountDomainService.getInstance().isAccountEligibleForCreation(nonEligibleAccount));
    }
}

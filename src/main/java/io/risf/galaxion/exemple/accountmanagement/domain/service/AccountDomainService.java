package io.risf.galaxion.exemple.accountmanagement.domain.service;

import io.risf.galaxion.exemple.accountmanagement.domain.model.Account;
import io.risf.galaxion.exemple.accountmanagement.domain.model.AccountEligibilityPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountDomainService {
    private AccountEligibilityPolicy accountEligibilityPolicy;

    public AccountDomainService(){

    }

    @Autowired(required = false)
    public void accountEligibilityPolicy(AccountEligibilityPolicy accountEligibilityPolicy) {
        this.accountEligibilityPolicy = accountEligibilityPolicy;
    }


    public boolean isAccountEligibleForCreation(Account account){
        return accountEligibilityPolicy.isAccountEligible(account);
    }

}


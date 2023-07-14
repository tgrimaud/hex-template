package io.risf.galaxion.exemple.accountmanagement.domain.service;

import io.risf.galaxion.exemple.accountmanagement.domain.model.Account;
import io.risf.galaxion.exemple.accountmanagement.domain.model.AccountEligibilityPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class AccountDomainService {
    private static AccountDomainService instance;
    private AccountEligibilityPolicy accountEligibilityPolicy;

    private AccountDomainService(){

    }
    
    public void accountEligibilityPolicy(AccountEligibilityPolicy accountEligibilityPolicy) {
        this.accountEligibilityPolicy = accountEligibilityPolicy;
    }

    public static AccountDomainService getInstance() {
        if (instance == null){
            instance = new AccountDomainService();
        }
        return instance;
    }


    public boolean isAccountEligibleForCreation(Account account){
        return accountEligibilityPolicy.isAccountEligible(account);
    }

}


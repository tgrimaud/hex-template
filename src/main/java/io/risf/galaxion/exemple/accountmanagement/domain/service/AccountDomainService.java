package io.risf.galaxion.exemple.accountmanagement.domain.service;

import io.risf.galaxion.exemple.accountmanagement.domain.model.Account;
import io.risf.galaxion.exemple.accountmanagement.domain.model.AccountEligibilityPolicy;


public class AccountDomainService {
    private static AccountDomainService instance;

    private AccountDomainService(){

    }

    public static AccountDomainService getInstance() {
        if (instance == null){
            instance = new AccountDomainService();
        }
        return instance;
    }


    public boolean isAccountEligibleForCreation(Account account){
        return account.getAge() >= 18;
    }

}


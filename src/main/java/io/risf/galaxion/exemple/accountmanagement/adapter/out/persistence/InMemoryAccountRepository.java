package io.risf.galaxion.exemple.accountmanagement.adapter.out.persistence;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAccountRepository implements AccountRepository {
    List<AccountEntity> accounts = new ArrayList<>();
    private static AccountRepository instance;

    private InMemoryAccountRepository(){}

    public static AccountRepository getInstance() {
        if (instance == null) {
            instance = new InMemoryAccountRepository();
        }
        return instance;
    }


    @Override
    public List<AccountEntity> findByEmail(String email) {
        List<AccountEntity> accountsFromEmail = new ArrayList<>();
        for(AccountEntity entity : accounts) {
            if (entity.getEmail().equals(email)){
                accountsFromEmail.add(entity);
            }
        }
        return accountsFromEmail;
    }

    public void save(AccountEntity entity){
        accounts.add(entity);
    }
}

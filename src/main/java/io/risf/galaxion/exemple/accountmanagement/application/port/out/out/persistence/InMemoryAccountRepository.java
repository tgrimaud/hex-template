package io.risf.galaxion.exemple.accountmanagement.application.port.out.out.persistence;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryAccountRepository implements AccountRepository {
    List<AccountEntity> accounts = new ArrayList<>();


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

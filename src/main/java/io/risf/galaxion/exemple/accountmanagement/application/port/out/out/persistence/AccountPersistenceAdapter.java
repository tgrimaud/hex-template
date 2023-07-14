package io.risf.galaxion.exemple.accountmanagement.application.port.out.out.persistence;

import io.risf.galaxion.exemple.accountmanagement.application.port.out.LoadAccountPort;
import io.risf.galaxion.exemple.accountmanagement.application.port.out.SaveAccountPort;
import io.risf.galaxion.exemple.accountmanagement.domain.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Component
public class AccountPersistenceAdapter implements SaveAccountPort, LoadAccountPort {

    private AccountRepository accountRepository;
    private AccountMapper accountMapper;

    @Autowired(required = false)
    public void accountRepository(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Autowired(required = false)
    public void accountMapper(AccountMapper accountMapper){
        this.accountMapper = accountMapper;
    }

    @Override
    public void saveAccount(Account account) {
        accountRepository.save(accountMapper.mapToEntity(account));
    }

    @Override
    public List<Account> loadAccountsByEmail(String email) {
        List<Account> accountsFromEmail = new ArrayList<>();
        for (AccountEntity entityFromEmail : accountRepository.findByEmail(email)) {
            accountsFromEmail.add(accountMapper.mapToDomainEntity(entityFromEmail));
        }
        return accountsFromEmail;
    }
}

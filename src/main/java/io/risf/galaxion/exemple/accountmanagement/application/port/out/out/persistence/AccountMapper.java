package io.risf.galaxion.exemple.accountmanagement.application.port.out.out.persistence;

import io.risf.galaxion.exemple.accountmanagement.domain.model.Account;
import io.risf.galaxion.exemple.accountmanagement.domain.model.AccountId;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {

    Account mapToDomainEntity(AccountEntity account) {
        return Account.withId(
                new AccountId(account.getId()),
                account.getFirstName(),
                account.getLastName(),
                account.getEmail(),
                account.getAge());
    }

    AccountEntity mapToEntity(Account account) {
        return new AccountEntity(
                account.getId() == null ? null : account.getId().getValue(),
                account.getFirstName(),
                account.getLastName(),
                account.getEmail(),
                account.getAge());
    }
}

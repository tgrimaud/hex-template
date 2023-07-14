package io.risf.galaxion.exemple.accountmanagement.application.port.out;

import io.risf.galaxion.exemple.accountmanagement.domain.model.Account;

import java.util.List;

public interface LoadAccountPort {
    public List<Account> loadAccountsByEmail(String email);
}

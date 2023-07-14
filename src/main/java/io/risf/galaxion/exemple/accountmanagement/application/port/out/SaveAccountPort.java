package io.risf.galaxion.exemple.accountmanagement.application.port.out;

import io.risf.galaxion.exemple.accountmanagement.domain.model.Account;

public interface SaveAccountPort {

    void saveAccount(Account account);
}

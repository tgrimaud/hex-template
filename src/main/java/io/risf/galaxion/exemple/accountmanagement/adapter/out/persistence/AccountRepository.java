package io.risf.galaxion.exemple.accountmanagement.adapter.out.persistence;

import java.util.List;

public interface AccountRepository {
    List<AccountEntity> findByEmail(String email);

    void save(AccountEntity mapToEntity);
}

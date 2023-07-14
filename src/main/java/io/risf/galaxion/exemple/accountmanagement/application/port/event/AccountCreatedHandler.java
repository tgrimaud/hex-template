package io.risf.galaxion.exemple.accountmanagement.application.port.event;

import io.risf.galaxion.exemple.accountmanagement.domain.model.AccountCreated;

public interface AccountCreatedHandler {
    public void handleAccountCreated(AccountCreated event);
}

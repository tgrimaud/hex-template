package io.risf.galaxion.exemple.accountmanagement.application.port.in;

import io.risf.galaxion.exemple.accountmanagement.domain.model.AccountId;

public record TerminateAccountCommand (AccountId id, String reason){
}

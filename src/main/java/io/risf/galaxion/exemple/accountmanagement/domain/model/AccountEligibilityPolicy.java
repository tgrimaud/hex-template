package io.risf.galaxion.exemple.accountmanagement.domain.model;

public interface AccountEligibilityPolicy {
    boolean isAccountEligible(Account account);
}

package io.risf.galaxion.exemple.accountmanagement.domain.model;

public class MajorAccountEligibilibittyPolicy implements AccountEligibilityPolicy {
    @Override
    public boolean isAccountEligible(Account account) {
        return account.getAge() >= 18;
    }
}

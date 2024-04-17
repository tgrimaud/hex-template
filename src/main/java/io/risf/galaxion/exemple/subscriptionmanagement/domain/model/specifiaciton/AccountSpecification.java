package io.risf.galaxion.exemple.subscriptionmanagement.domain.model.specifiaciton;

import io.risf.galaxion.exemple.subscriptionmanagement.application.shared.AbstractSpecification;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Account;

public class AccountSpecification extends AbstractSpecification {

    @Override
    public boolean isSatisfiedBy(Object candidate) {
        return candidate instanceof Account;
    }
}

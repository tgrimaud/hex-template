package io.risf.galaxion.exemple.subscriptionmanagement.domain.model.specifiaciton;

import io.risf.galaxion.exemple.accountmanagement.domain.model.Account;
import io.risf.galaxion.exemple.shared.AbstractSpecification;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Subscription;

public class SubscriptionSpecification extends AbstractSpecification {

    @Override
    public boolean isSatisfiedBy(Object candidate) {
        return candidate instanceof Subscription;
    }
}

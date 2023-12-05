package io.risf.galaxion.exemple.subscriptionmanagement.domain.model.specifiaciton;

import io.risf.galaxion.exemple.shared.AbstractSpecification;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Service;

public class ServiceSpecification extends AbstractSpecification {

    @Override
    public boolean isSatisfiedBy(Object candidate) {
        return candidate instanceof Service;
    }
}

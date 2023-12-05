package io.risf.galaxion.exemple.accountmanagement.domain.model;

import io.risf.galaxion.exemple.shared.AbstractSpecification;

public class MajorAccountSpecification extends AbstractSpecification {

    @Override
    public boolean isSatisfiedBy(Object candidate) {
        if (! (candidate instanceof Account))
            return false;
        else
        return ((Account)candidate).getAge() >= 18;
    }
}

package io.risf.galaxion.exemple.accountmanagement.domain.model;

import io.risf.galaxion.exemple.shared.AbstractSpecification;

public class NameAccountSpecification extends AbstractSpecification {
    private String name = "";

    public NameAccountSpecification(String name) {
        this.name = name;
    }
    @Override

    public boolean isSatisfiedBy(Object candidate) {
        if (! (candidate instanceof Account))
            return false;
        else
            return ((Account)candidate).getFirstName().equals(this.name);
    }
}

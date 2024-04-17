package io.risf.galaxion.exemple.subscriptionmanagement.application.shared;

public interface Specification {

    boolean isSatisfiedBy(Object candidate);

    Specification and(Specification other);

    Specification or(Specification other);

    Specification not();

}

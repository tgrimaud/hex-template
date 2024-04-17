package io.risf.galaxion.exemple.subscriptionmanagement.application.shared;

public abstract class AbstractSpecification implements Specification {

    public Specification and(Specification other) {
        return new AndSpecification(this, other);
    }

    public Specification or(Specification other) {
        return new OrSpecification(this, other);
    }

    public Specification not() {
        return new NotSpecification(this);
    }

    public class AndSpecification extends AbstractSpecification {
        Specification one;
        Specification other;

        public AndSpecification(Specification x, Specification y) {
            one = x;
            other = y;
        }

        public boolean isSatisfiedBy(Object candidate) {
            return one.isSatisfiedBy(candidate) &&
                    other.isSatisfiedBy(candidate);
        }
    }

    public class OrSpecification extends AbstractSpecification {
        Specification one;
        Specification other;

        public OrSpecification(Specification x, Specification y) {
            one = x;
            other = y;
        }

        public boolean isSatisfiedBy(Object candidate) {
            return one.isSatisfiedBy(candidate) ||
                    other.isSatisfiedBy(candidate);
        }
    }

    public class NotSpecification extends AbstractSpecification {
        Specification wrapped;

        public NotSpecification(Specification x) {
            wrapped = x;
        }

        public boolean isSatisfiedBy(Object candidate) {
            return !wrapped.isSatisfiedBy(candidate);
        }
    }
}

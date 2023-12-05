package io.risf.galaxion.exemple.subscriptionmanagement.domain.exception;

import io.risf.galaxion.exemple.accountmanagement.domain.model.DomainException;

public class InvalidSubscriptionException extends DomainException {
    private final int exceptionCode = 100;

    public InvalidSubscriptionException(String message) {
        super(message);
    }

    public InvalidSubscriptionException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidSubscriptionException(Throwable cause) {
        super(cause);
    }

    public int getExceptionCode(){
        return exceptionCode;
    }

}

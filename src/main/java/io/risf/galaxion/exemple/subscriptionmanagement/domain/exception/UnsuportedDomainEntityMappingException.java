package io.risf.galaxion.exemple.subscriptionmanagement.domain.exception;

import io.risf.galaxion.exemple.accountmanagement.domain.model.DomainException;

public class UnsuportedDomainEntityMappingException extends DomainException {
    private final int exceptionCode = 101;

    public UnsuportedDomainEntityMappingException(String message) {
        super(message);
    }

    public UnsuportedDomainEntityMappingException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnsuportedDomainEntityMappingException(Throwable cause) {
        super(cause);
    }

    public int getExceptionCode() {
        return exceptionCode;
    }
}
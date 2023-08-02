package io.risf.galaxion.exemple.accountmanagement.domain.model;

public class AccountNonEligibleException extends DomainException {
    private final int exceptionCode = 666;

    public AccountNonEligibleException(String message) {
        super(message);
    }

    public AccountNonEligibleException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountNonEligibleException( Throwable cause) {
        super(cause);
    }

    public int getExceptionCode(){
        return exceptionCode;
    }

}

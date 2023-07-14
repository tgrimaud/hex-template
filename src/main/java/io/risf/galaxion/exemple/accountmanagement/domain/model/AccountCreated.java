package io.risf.galaxion.exemple.accountmanagement.domain.model;

import lombok.Builder;

import java.util.Date;

@Builder
public class AccountCreated implements DomainEvent {
    private Date occurredAt;
    private String version;
    private AccountId accountId;
    private String accountFirstName;
    private String accountLastName;
    private String accountEmail;
    private int accountAge;

    public AccountCreated(Date occurredAt, String version, AccountId accountId, String accountFirstName, String accountLastName, String accountEmail, int accountAge){
        this.occurredAt = occurredAt;
        this.version = version;
        this.accountId = accountId;
        this.accountFirstName = accountFirstName;
        this.accountLastName = accountLastName;
        this.accountEmail = accountEmail;
        this.accountAge = accountAge;
    }

    @Override
    public Date occurredAt() {
        return occurredAt;
    }

    @Override
    public String version() {
        return version;
    }

    public Long acountId() { return accountId.getValue();}

    public String accountFirstName() { return accountFirstName;}

    public String accountLastName() { return accountLastName;}

    public String accountEmail() { return accountEmail;}

    public int accountAge() {return accountAge;}

}

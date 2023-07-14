package io.risf.galaxion.exemple.accountmanagement.domain.model;

import io.risf.galaxion.exemple.accountmanagement.application.port.event.AccountCreatedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AccountEventPublisher {
    //In case we want to use the ApplicationEventPublisher of SpringBoot
    // private ApplicationEventPublisher publisher;

    private static AccountEventPublisher instance;

    @Autowired
    private List<AccountCreatedHandler> accountCreatedHandlers = new ArrayList<>();

    public AccountEventPublisher(){}

    public static AccountEventPublisher getInstance(){
        if (instance == null){
            instance = new AccountEventPublisher();
        }
        return instance;
    }

    public void publishAccountCreatedEvent(AccountCreated event) {
        for (AccountCreatedHandler accountCreatedHandler: accountCreatedHandlers) {
            accountCreatedHandler.handleAccountCreated(event);
        }
        //publisher.publishEvent(event);
    }

    public void addAccountCreatedHandler(AccountCreatedHandler handler) {
        accountCreatedHandlers.add(handler);
    }

    public void removeAccountCreatedHandler(AccountCreatedHandler handler) {
        accountCreatedHandlers.remove(handler);
    }
}

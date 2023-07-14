package io.risf.galaxion.exemple.accountmanagement.application.service;

import io.risf.galaxion.exemple.accountmanagement.application.port.in.CreateAccountCommand;
import io.risf.galaxion.exemple.accountmanagement.application.port.in.CreateAccountUseCase;
import io.risf.galaxion.exemple.accountmanagement.application.port.out.SaveAccountPort;
import io.risf.galaxion.exemple.accountmanagement.domain.DomainRegistry;
import io.risf.galaxion.exemple.accountmanagement.domain.model.AccountEventFactory;
import io.risf.galaxion.exemple.accountmanagement.domain.model.AccountNonEligibleException;
import io.risf.galaxion.exemple.accountmanagement.domain.model.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateAccountApplicationService implements CreateAccountUseCase {

    private SaveAccountPort saveAccountPort;

    @Autowired(required = false)
    public void saveAccountPort(SaveAccountPort saveAccountPort){
        this.saveAccountPort = saveAccountPort;
    }

    @Override
    public void createAccount(CreateAccountCommand command) {
        Account aNewAccount = Account.withoutId(command.firstName(), command.lastName(), command.email(), command.age());
        if (DomainRegistry.accountDomainService().isAccountEligibleForCreation(aNewAccount)){
            saveAccountPort.saveAccount(aNewAccount);
            DomainRegistry.accountEventPublisher().publishAccountCreatedEvent(AccountEventFactory.createAccountCreatedEventV1(aNewAccount));
        }
        else {
            throw new AccountNonEligibleException("The user is not Eligible");
        }
    }
}

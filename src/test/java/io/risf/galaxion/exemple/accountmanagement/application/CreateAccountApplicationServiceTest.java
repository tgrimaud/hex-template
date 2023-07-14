package io.risf.galaxion.exemple.accountmanagement.application;

import io.risf.galaxion.exemple.accountmanagement.application.port.in.CreateAccountCommand;
import io.risf.galaxion.exemple.accountmanagement.application.port.in.CreateAccountCommandMother;
import io.risf.galaxion.exemple.accountmanagement.application.port.out.SaveAccountPort;
import io.risf.galaxion.exemple.accountmanagement.application.service.CreateAccountApplicationService;
import io.risf.galaxion.exemple.accountmanagement.domain.model.AccountNonEligibleException;
import io.risf.galaxion.exemple.accountmanagement.domain.model.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateAccountApplicationServiceTest {


    @Test
    void testCreateEligibleAccount()  {
        CreateAccountApplicationService createAccountApplicationService = new CreateAccountApplicationService();
        final Account[] savedAccount = new Account[1];
        createAccountApplicationService.saveAccountPort(new SaveAccountPort() {
            @Override
            public void saveAccount(Account account) {
                savedAccount[0] = account;
            }
        });

        CreateAccountCommand command = new CreateAccountCommandMother()
                .majorAccount().build();

        createAccountApplicationService.createAccount(command);

        Assertions.assertEquals(savedAccount[0].getAge(), command.age());
        Assertions.assertEquals(savedAccount[0].getFirstName(), command.firstName());
        Assertions.assertEquals(savedAccount[0].getLastName(), command.lastName());
        Assertions.assertEquals(savedAccount[0].getEmail(), command.email());

    }

    @Test
    void testCreateNonEligibleAccount()  {
        CreateAccountApplicationService createAccountApplicationService = new CreateAccountApplicationService();
        final Account[] savedAccount = new Account[1];
        createAccountApplicationService.saveAccountPort(new SaveAccountPort() {
            @Override
            public void saveAccount(Account account) {
                savedAccount[0] = account;
            }
        });

        CreateAccountCommand command = new CreateAccountCommandMother()
                .minorAccount().build();
        ;

        Assertions.assertThrows(AccountNonEligibleException.class,() -> {
            createAccountApplicationService.createAccount(command);
            }
        );

    }
}
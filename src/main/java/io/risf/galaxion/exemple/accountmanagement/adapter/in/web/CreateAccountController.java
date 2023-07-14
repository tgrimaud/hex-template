package io.risf.galaxion.exemple.accountmanagement.adapter.in.web;

import io.risf.galaxion.exemple.accountmanagement.application.port.in.CreateAccountCommand;
import io.risf.galaxion.exemple.accountmanagement.application.port.in.CreateAccountUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@RequiredArgsConstructor
public class CreateAccountController {

    private CreateAccountUseCase createAccountUserCase;

    @Autowired(required = false)
    public void createAccountUserCase(CreateAccountUseCase createAccountUserCase){
        this.createAccountUserCase = createAccountUserCase;
    }

    @PostMapping(path = "/account/create/{firstName}/{lastName}/{email}/{age}")
    void createAccount(
            @PathVariable("firstName") String firstName,
            @PathVariable("lastName") String lastName,
            @PathVariable("email") String email,
            @PathVariable("age") int age){
        CreateAccountCommand command = new CreateAccountCommand(firstName, lastName, email, age);
        createAccountUserCase.createAccount(command);
    }
}

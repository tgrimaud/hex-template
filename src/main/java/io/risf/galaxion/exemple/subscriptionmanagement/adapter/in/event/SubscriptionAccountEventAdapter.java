package io.risf.galaxion.exemple.subscriptionmanagement.adapter.in.event;

import io.risf.galaxion.exemple.accountmanagement.application.port.event.AccountCreatedHandler;
import io.risf.galaxion.exemple.accountmanagement.domain.model.AccountCreated;
import io.risf.galaxion.exemple.subscriptionmanagement.application.port.in.CreateSubscriptionCommand;
import io.risf.galaxion.exemple.subscriptionmanagement.application.port.in.CreateSubscriptionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SubscriptionAccountEventAdapter implements AccountCreatedHandler {

    private CreateSubscriptionUseCase createSubscriptionUseCase;

    @Autowired(required = false)
    public void createSubscriptionUseCase(CreateSubscriptionUseCase createSubscriptionUseCase){
        this.createSubscriptionUseCase = createSubscriptionUseCase;
    }


    @Override
    public void handleAccountCreated(AccountCreated event) {
        CreateSubscriptionCommand command = new CreateSubscriptionCommand(event.acountId(), event.accountFirstName(), event.accountLastName());
        createSubscriptionUseCase.createSubscription(command);
    }
}

package io.risf.galaxion.exemple.subscriptionmanagement.domain.service;

import io.risf.galaxion.exemple.subscriptionmanagement.domain.exception.InvalidSubscriptionException;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Account;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Node;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.specifiaciton.AccountSpecification;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.specifiaciton.EquipmentSpecification;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionService {

    public void subscribe (Node origin, Node destination) {
        AccountSpecification accountSpecification = new AccountSpecification();
        EquipmentSpecification equipmentSpecification = new EquipmentSpecification();

        if (accountSpecification.isSatisfiedBy(origin) && equipmentSpecification.not().isSatisfiedBy(destination)) {
             ((Account)origin).subscribe(destination);
        }
        else {
            throw new InvalidSubscriptionException("Cannot Subscribe " +  origin.getClass().getSimpleName()+ " with " + destination.getClass().getSimpleName());
        }
    }
}

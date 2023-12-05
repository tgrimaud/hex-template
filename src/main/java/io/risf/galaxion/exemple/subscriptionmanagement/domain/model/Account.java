package io.risf.galaxion.exemple.subscriptionmanagement.domain.model;

import io.risf.galaxion.exemple.subscriptionmanagement.domain.exception.InvalidSubscriptionException;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.specifiaciton.AddOnSpecification;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.specifiaciton.EquipmentSpecification;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.specifiaciton.SubscriptionSpecification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Account extends Node {
    @Setter
    String firstName;

    @Setter
    String lastName;

    String email;
    int age;

    public Account(NodeId nodeId) {
        super();
        this.setNodeID(nodeId);
    }

    public static Account withoutId() {
        return new Account(NodeId.nextAvailableId());
    }

    public static Account withId(NodeId accountId) {
        return new Account(accountId);
    }

    public void subscribe(Node node) {
        EquipmentSpecification equipmentSpecification = new EquipmentSpecification();
        if (equipmentSpecification.not().isSatisfiedBy(node)) {
            Subscription subscription = Subscription.withoutId(this, node);
            subscription.setCreatedAt(LocalDate.now());
            this.relations.add(subscription);
        }
        else {
            throw new InvalidSubscriptionException("An Account cannot subscribe to an Equipment");
        }
    }

    public void addAddon(Node node)  {
        this.relations.add(AddOn.withoutId(this, node));
    }

    public List<Subscription> getSubscriptions() {
        List<Subscription> subscriptions = new ArrayList<>();
        SubscriptionSpecification subscriptionSpecification = new SubscriptionSpecification();
        for (Relation relation : relations) {
            if (subscriptionSpecification.isSatisfiedBy(relation)) {
                subscriptions.add((Subscription) relation);
            }
        }
        return subscriptions;
    }

    public List<AddOn> getAddOns() {
        List<AddOn> addOns = new ArrayList<>();
        AddOnSpecification addOnSpecification = new AddOnSpecification();
        for (Relation relation : relations) {
            if (addOnSpecification.isSatisfiedBy(relation)) {
                addOns.add((AddOn) relation);
            }
        }
        return addOns;
    }

}

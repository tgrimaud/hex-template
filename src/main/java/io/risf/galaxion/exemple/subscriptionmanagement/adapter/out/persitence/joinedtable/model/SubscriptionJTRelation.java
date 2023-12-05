package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name="subscription_joinedtable")
//@DiscriminatorValue("SUBSCRIPTION")
public class SubscriptionJTRelation extends RelationJT {
    private LocalDate createdAt;
    private LocalDate lastUpdatedAt;
    private LocalDate terminatedAt;
}

package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name="subscription_tableperclass")
public class SubscriptionTPCRelation extends RelationTPC {
    private LocalDate createdAt;
    private LocalDate lastUpdatedAt;
    private LocalDate terminatedAt;
}

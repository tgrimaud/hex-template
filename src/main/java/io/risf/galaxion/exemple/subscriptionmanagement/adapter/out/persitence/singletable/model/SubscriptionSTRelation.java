package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Setter
@Getter
public class SubscriptionSTRelation extends RelationST {
    private LocalDate createdAt;
    private LocalDate lastUpdatedAt;
    private LocalDate terminatedAt;
}

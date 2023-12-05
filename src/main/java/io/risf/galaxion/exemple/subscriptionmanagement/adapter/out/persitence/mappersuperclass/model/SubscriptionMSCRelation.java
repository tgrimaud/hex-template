package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.model;

import org.springframework.context.annotation.Profile;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="subscription_mappersuperclass")
@Profile("mappersuperclass")
public class SubscriptionMSCRelation extends RelationMSC {
    private String startDate;
    private String endDate;
}

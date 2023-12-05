package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.model;

import lombok.Setter;
import org.springframework.context.annotation.Profile;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="addon_mappersuperclass")
@Setter
@Profile("mappersuperclass")
public class AddOnMSCRelation extends RelationMSC {
    private String fromDate;
}

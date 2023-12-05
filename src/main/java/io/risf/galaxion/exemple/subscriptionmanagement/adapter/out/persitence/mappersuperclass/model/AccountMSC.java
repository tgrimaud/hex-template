package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.model;

import org.springframework.context.annotation.Profile;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="acoount_mappersuperclass")
@Profile("mappersuperclass")
public class AccountMSC extends NodeMSC {
    private String name;
    private String type;
}

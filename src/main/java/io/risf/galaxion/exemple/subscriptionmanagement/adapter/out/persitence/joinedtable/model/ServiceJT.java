package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name="service_joinedtable")
//@DiscriminatorValue("SERVICE")
public class ServiceJT extends NodeJT {
    private String number;
}


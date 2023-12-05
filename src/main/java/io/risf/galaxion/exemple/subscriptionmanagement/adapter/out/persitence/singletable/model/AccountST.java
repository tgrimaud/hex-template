package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
public class AccountST extends NodeST {
    private String firstName;
    private String LastName;
    private String type;
}

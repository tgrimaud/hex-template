package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="acoount_joinedtable")
//@DiscriminatorValue("ACCOUNT")
@Getter
@Setter
public class AccountJT extends NodeJT {
    private String firstName;
    private String LastName;
    private String type;
}

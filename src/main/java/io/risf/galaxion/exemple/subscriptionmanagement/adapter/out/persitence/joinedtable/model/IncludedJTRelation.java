package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name="included_joinedtable")
//@DiscriminatorValue("INCLUDED")
public class IncludedJTRelation extends RelationJT {

}

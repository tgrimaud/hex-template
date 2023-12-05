package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.RelationJT;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name="included_tableperclass")
//@DiscriminatorValue("INCLUDED")
public class IncludedTPCRelation extends RelationTPC {

}

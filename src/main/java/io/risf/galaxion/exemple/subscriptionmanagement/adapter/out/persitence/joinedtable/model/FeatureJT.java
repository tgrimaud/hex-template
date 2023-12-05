package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Builder
@NoArgsConstructor
@Table(name="feature_joinedtable")
//@DiscriminatorValue("FEATURE")
public class FeatureJT extends NodeJT {

}

package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.NodeST;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Builder
@NoArgsConstructor
@Table(name="feature_tableperclass")
public class FeatureTPC extends NodeTPC {

}

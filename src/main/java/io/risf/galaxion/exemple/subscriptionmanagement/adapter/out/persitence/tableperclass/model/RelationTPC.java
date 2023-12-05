package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@Setter
@Getter
public abstract class RelationTPC {

    @EmbeddedId
    RelationTPCId relationId;

    @Setter
    @Getter
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "origin_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "origin_id_fk"), nullable = false)
    NodeTPC origin;

    @Setter
    @Getter
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destination_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "destination_id_fk"), nullable = false)
    NodeTPC destination;
}

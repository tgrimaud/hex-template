package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@Setter
@Getter
public abstract class RelationST {

    @EmbeddedId
    RelationSTId relationId;


    @Setter
    @Getter
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "origin_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "origin_id_fk"), nullable = false)
    NodeST origin;

    @Setter
    @Getter
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destination_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "destination_id_fk"), nullable = false)
    NodeST destination;
}

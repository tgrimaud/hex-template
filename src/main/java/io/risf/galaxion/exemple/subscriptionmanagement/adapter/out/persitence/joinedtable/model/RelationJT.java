package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Inheritance(strategy= InheritanceType.JOINED)
//@DiscriminatorColumn(name = "RELATION_TYPE")
public abstract class RelationJT {

    @EmbeddedId
    RelationJTId relationId;

    @Setter
    @Getter
    @OneToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "origin_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "origin_id_fk"), nullable = false)
    NodeJT origin;

    @Setter
    @Getter
    @OneToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "destination_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "destination_id_fk"), nullable = false)
    NodeJT destination;
}

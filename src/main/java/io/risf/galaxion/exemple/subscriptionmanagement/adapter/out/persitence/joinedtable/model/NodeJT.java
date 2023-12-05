package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
//@DiscriminatorColumn(name = "NODE_TYPE")
@Setter
@Getter
public abstract class NodeJT {

    @EmbeddedId
    private NodeJTId nodeId;
}


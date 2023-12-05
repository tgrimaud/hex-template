package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Profile;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS)
@Setter
@Getter
public abstract class NodeTPC {

    @EmbeddedId
    private NodeTPCId nodeId;
}


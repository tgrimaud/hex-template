package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.model;

import lombok.Setter;
import org.springframework.context.annotation.Profile;

import javax.persistence.EmbeddedId;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Setter
@Profile("mappersuperclass")
public class NodeMSC {

    @EmbeddedId
    private NodeMSCId id;
}

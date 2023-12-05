package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Profile;

import javax.persistence.*;

@MappedSuperclass
@Setter
@Profile("mappersuperclass")
public class RelationMSC {

    @EmbeddedId
    RelationMSCId id;

    @Setter
    @Getter
    @OneToOne(fetch = FetchType.EAGER)
    EquipmentMSC origin;

    @Setter
    @Getter
    @OneToOne(fetch = FetchType.EAGER)
    EquipmentMSC destination;
}

package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.model;

import lombok.*;
import org.springframework.context.annotation.Profile;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="equipment_mappersuperclass")
@Profile("mappersuperclass")
public class EquipmentMSC extends NodeMSC {

    @Setter
    private String description;

    @Setter
    private String type;
}

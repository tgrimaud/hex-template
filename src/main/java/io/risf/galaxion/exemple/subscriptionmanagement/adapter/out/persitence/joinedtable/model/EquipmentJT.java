package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="equipment_joinedtable")
//@DiscriminatorValue("EQUIPMENT")
public class EquipmentJT extends NodeJT {

    private String serialNumber;

    private String partNumber;
}

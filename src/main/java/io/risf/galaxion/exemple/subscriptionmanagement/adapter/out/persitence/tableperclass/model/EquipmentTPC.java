package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model;

import lombok.*;
import org.springframework.context.annotation.Profile;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="equipment_tableperclass")
public class EquipmentTPC extends NodeTPC {


    private String serialNumber;

    private String partNumber;
}

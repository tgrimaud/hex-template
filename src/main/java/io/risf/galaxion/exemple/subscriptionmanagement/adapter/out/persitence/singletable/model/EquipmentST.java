package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EquipmentST extends NodeST {


    private String serialNumber;

    private String partNumber;
}

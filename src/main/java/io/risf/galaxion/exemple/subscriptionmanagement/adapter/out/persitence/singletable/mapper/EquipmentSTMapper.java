package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.EquipmentST;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.NodeST;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.NodeSTId;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Equipment;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Node;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;

public class EquipmentSTMapper implements NodeSTMapper {

    @Override
    public Node mapToDomainEntity(NodeST node) {
        Equipment equipment = Equipment.withId(NodeId.of(node.getNodeId().getId()));

        equipment.setSerialNumber(((EquipmentST)node).getSerialNumber());
        equipment.setPartNumber(((EquipmentST)node).getPartNumber());

        return equipment;
    }

    @Override
    public NodeST mapToEntity(Node node) {
        EquipmentST equipment = new EquipmentST();

        equipment.setSerialNumber(((Equipment)node).getSerialNumber());
        equipment.setPartNumber(((Equipment)node).getPartNumber());
        equipment.setNodeId(new NodeSTId(node.getNodeID().getId()));

        return equipment;
    }
}

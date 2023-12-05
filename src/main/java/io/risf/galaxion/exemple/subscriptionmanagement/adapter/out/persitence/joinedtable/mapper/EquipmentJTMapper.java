package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.EquipmentJT;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.NodeJT;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.NodeJTId;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Equipment;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Node;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;

public class EquipmentJTMapper implements NodeJTMapper {

    @Override
    public Node mapToDomainEntity(NodeJT node) {
        Equipment equipment = Equipment.withId(NodeId.of(node.getNodeId().getId()));

        equipment.setSerialNumber(((EquipmentJT)node).getSerialNumber());
        equipment.setPartNumber(((EquipmentJT)node).getPartNumber());

        return equipment;
    }

    @Override
    public NodeJT mapToEntity(Node node) {
        EquipmentJT equipment = new EquipmentJT();

        equipment.setSerialNumber(((Equipment)node).getSerialNumber());
        equipment.setPartNumber(((Equipment)node).getPartNumber());
        equipment.setNodeId(new NodeJTId(node.getNodeID().getId()));

        return equipment;
    }
}

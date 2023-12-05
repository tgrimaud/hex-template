package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.EquipmentTPC;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.NodeTPC;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.NodeTPCId;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Equipment;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Node;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;

public class EquipmentTPCMapper implements NodeTPCMapper {

    @Override
    public Node mapToDomainEntity(NodeTPC node) {
        Equipment equipment = Equipment.withId(NodeId.of(node.getNodeId().getId()));

        equipment.setSerialNumber(((EquipmentTPC)node).getSerialNumber());
        equipment.setPartNumber(((EquipmentTPC)node).getPartNumber());

        return equipment;
    }

    @Override
    public NodeTPC mapToEntity(Node node) {
        EquipmentTPC equipment = new EquipmentTPC();

        equipment.setSerialNumber(((Equipment)node).getSerialNumber());
        equipment.setPartNumber(((Equipment)node).getPartNumber());
        equipment.setNodeId(new NodeTPCId(node.getNodeID().getId()));

        return equipment;
    }
}

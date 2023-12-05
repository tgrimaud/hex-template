package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.mapper.NodeMapperFactory;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.mapper.RelationMapperFactory;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.*;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.repository.NodeTPCRepository;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.repository.RelationTPCRepository;
import io.risf.galaxion.exemple.subscriptionmanagement.application.port.out.AddEquipmentAndService;
import io.risf.galaxion.exemple.subscriptionmanagement.application.port.out.AddNodeTree;
import io.risf.galaxion.exemple.subscriptionmanagement.application.port.out.GetNodeTree;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Node;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Relation;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Getter
@Component
@RequiredArgsConstructor
@Profile("tableperclass")
public class GraphTPCAdapter implements AddEquipmentAndService , AddNodeTree, GetNodeTree {
    private static org.slf4j.Logger Logger = LoggerFactory.getLogger(GraphTPCAdapter.class);

    private final NodeTPCRepository nodeRepositoryTPC;
    private final RelationTPCRepository relationRepositoryTPC;

    @Override
    public void addEquipmentAndServiceNodes(){
        EquipmentTPC equipment = new EquipmentTPC();
        NodeTPCId equipmentId = new NodeTPCId();
        equipmentId.setId("1L");
        equipment.setSerialNumber("Test Equipment 1");
        equipment.setPartNumber("Type 1");
        equipment.setNodeId(equipmentId);
        nodeRepositoryTPC.save(equipment);

        ServiceTPC service = new ServiceTPC();
        service.setNumber("Test Service 1");
        NodeTPCId serviceId = new NodeTPCId();
        serviceId.setId("2L");
        service.setNodeId(serviceId);
        nodeRepositoryTPC.save(service);


        AddOnTPCRelation addon = new AddOnTPCRelation();
        addon.setOrigin(service);
        addon.setDestination(equipment);
        RelationTPCId addonId = new RelationTPCId();
        addonId.setId("1L");
        addon.setRelationId(addonId);

        relationRepositoryTPC.save(addon);

        RelationTPC relation = relationRepositoryTPC.getById(new RelationTPCId("1L"));

        Logger.info("Nb Node Entries TPC {}", nodeRepositoryTPC.findAll().size());
    }

    @Override
    public void addNodeTree(Node node) {
        NodeTPC nodeEntity = NodeMapperFactory.getNodeMapper(node).mapToEntity(node);
        nodeRepositoryTPC.save(nodeEntity);

        for (Relation relation : node.getRelations()) {
            RelationTPC relationEntity = RelationMapperFactory.getRelationMapper(relation).mapToEntity(relation);
            relationEntity.setOrigin(nodeEntity);
            this.addNodeTree(relation.getDestination());
            relationEntity.setDestination(nodeRepositoryTPC.getById(new NodeTPCId(relation.getDestination().getNodeID().getId())));
            relationRepositoryTPC.save(relationEntity);
        }
    }

    @Override
    public Node getNodeBranch(NodeId nodeId) {
        Logger.info("Node Id : {}" , nodeId.getId());
        Map<NodeTPCId, NodeTPC> nodeEntities = new HashMap<NodeTPCId, NodeTPC>();

        NodeTPC nodeEntity = this.getNode(nodeEntities, nodeId);

        Node node = NodeMapperFactory.getNodeMapper(nodeEntity).mapToDomainEntity(nodeEntity);

        for (RelationTPC relationEntity : relationRepositoryTPC.findAllByOrigin(nodeEntity)) {
            Relation relation = RelationMapperFactory.getRelationMapper(relationEntity).mapToDomainEntity(relationEntity);
            node.getRelations().add(relation);
            Logger.info("Relation Id : {}" , relation.getRelationId().getId());
            relation.setDestination(getNodeBranch(new NodeId(relationEntity.getDestination().getNodeId().getId())));
        }
        return node;
    }


    private NodeTPC getNode(Map<NodeTPCId, NodeTPC> nodeEntities, NodeId id) {
        Logger.info("getNode -> Node Id : {}" , id);
        if (!nodeEntities.containsKey(id)) {
            NodeTPC entity = nodeRepositoryTPC.getById(new NodeTPCId(id.getId()));
            nodeEntities.put(entity.getNodeId(), entity);
        }
        return nodeEntities.get(new NodeTPCId(id.getId()));
    }
}

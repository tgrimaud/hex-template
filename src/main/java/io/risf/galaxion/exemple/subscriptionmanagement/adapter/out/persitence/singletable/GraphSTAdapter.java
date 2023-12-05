package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.mapper.NodeMapperFactory;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.mapper.RelationMapperFactory;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.*;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.repository.NodeSTRepository;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.repository.RelationSTRepository;
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
@Profile("singletable")
public class GraphSTAdapter implements AddEquipmentAndService, AddNodeTree, GetNodeTree {
    private static org.slf4j.Logger Logger = LoggerFactory.getLogger(GraphSTAdapter.class);

    private final NodeSTRepository nodeRepositoryST;
    private final RelationSTRepository relationRepositoryST;

    public void addEquipmentAndServiceNodes(){
        EquipmentST equipment = new EquipmentST();
        NodeSTId equipmentId = new NodeSTId();
        equipmentId.setId("1L");
        equipment.setSerialNumber("Test Equipment 1");
        equipment.setPartNumber("Type 1");
        equipment.setNodeId(equipmentId);
        nodeRepositoryST.save(equipment);

        ServiceST service = new ServiceST();
        service.setNumber("Test Service 1");
        NodeSTId serviceId = new NodeSTId();
        serviceId.setId("2L");
        service.setNodeId(serviceId);
        nodeRepositoryST.save(service);


        AddOnSTRelation addon = new AddOnSTRelation();
        addon.setOrigin(service);
        addon.setDestination(equipment);
        RelationSTId addonId = new RelationSTId();
        addonId.setId("1L");
        addon.setRelationId(addonId);

        relationRepositoryST.save(addon);

        RelationST relation = relationRepositoryST.getById(new RelationSTId("1L"));

        Logger.info("Nb Node Entries ST {}", nodeRepositoryST.findAll().size());
    }

    @Override
    public void addNodeTree(Node node) {
        NodeST nodeEntity = NodeMapperFactory.getNodeMapper(node).mapToEntity(node);
        nodeRepositoryST.save(nodeEntity);

        for (Relation relation : node.getRelations()) {
            RelationST relationEntity = RelationMapperFactory.getRelationMapper(relation).mapToEntity(relation);
            relationEntity.setOrigin(nodeEntity);
            this.addNodeTree(relation.getDestination());
            relationEntity.setDestination(nodeRepositoryST.getById(new NodeSTId(relation.getDestination().getNodeID().getId())));
            relationRepositoryST.save(relationEntity);
        }
    }

    @Override
    public Node getNodeBranch(NodeId nodeId) {
        Logger.info("Node Id : {}" , nodeId.getId());
        Map<NodeSTId, NodeST> nodeEntities = new HashMap<NodeSTId, NodeST>();


        NodeST nodeEntity = this.getNode(nodeEntities, nodeId);

        Node node = NodeMapperFactory.getNodeMapper(nodeEntity).mapToDomainEntity(nodeEntity);

        for (RelationST relationEntity : relationRepositoryST.findAllByOrigin(nodeEntity)) {
            Relation  relation = RelationMapperFactory.getRelationMapper(relationEntity).mapToDomainEntity(relationEntity);
            node.getRelations().add(relation);
            Logger.info("Relation Id : {}" , relation.getRelationId().getId());
            relation.setDestination(getNodeBranch(new NodeId(relationEntity.getDestination().getNodeId().getId())));
        }
        return node;
    }

    private NodeST getNode(Map<NodeSTId, NodeST> nodeEntities, NodeId id) {
        Logger.info("getNode -> Node Id : {}" , id);
        if (!nodeEntities.containsKey(id)) {
            NodeST entity = nodeRepositoryST.getById(new NodeSTId(id.getId()));
            nodeEntities.put(entity.getNodeId(), entity);
        }
        return nodeEntities.get(new NodeSTId(id.getId()));
    }

}

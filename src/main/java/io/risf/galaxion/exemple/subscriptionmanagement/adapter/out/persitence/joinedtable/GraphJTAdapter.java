package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.mapper.NodeMapperFactory;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.mapper.RelationMapperFactory;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.repository.NodeJTRepository;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.repository.RelationJTRepository;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.*;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Component
@RequiredArgsConstructor
@Profile("joinedtable")
public class GraphJTAdapter implements AddEquipmentAndService, AddNodeTree, GetNodeTree {
    private static org.slf4j.Logger Logger = LoggerFactory.getLogger(GraphJTAdapter.class);

    private final NodeJTRepository nodeRepositoryJT;
    private final RelationJTRepository relationRepositoryJT;

    public void addEquipmentAndServiceNodes(){
        EquipmentJT equipment = new EquipmentJT();
        NodeJTId equipmentId = new NodeJTId();
        equipmentId.setId("1L");
        equipment.setSerialNumber("Test Equipment 1");
        equipment.setPartNumber("Type 1");
        equipment.setNodeId(equipmentId);
        nodeRepositoryJT.save(equipment);

        ServiceJT service = new ServiceJT();
        service.setNumber("Test Service 1");
        NodeJTId serviceId = new NodeJTId();
        serviceId.setId("2L");
        service.setNodeId(serviceId);
        nodeRepositoryJT.save(service);


        AddOnJTRelation addon = new AddOnJTRelation();
        addon.setOrigin(service);
        addon.setDestination(equipment);
        RelationJTId addonId = new RelationJTId();
        addonId.setId("1L");
        addon.setRelationId(addonId);

        relationRepositoryJT.save(addon);

        RelationJT relation = relationRepositoryJT.getById(new RelationJTId("1L"));

        Logger.info("Nb Node Entries JT {}", nodeRepositoryJT.findAll().size());
    }


    @Override
    public void addNodeTree(Node node) {
        NodeJT nodeEntity = NodeMapperFactory.getNodeMapper(node).mapToEntity(node);
        nodeRepositoryJT.save(nodeEntity);

        for (Relation relation : node.getRelations()) {
            RelationJT relationEntity = RelationMapperFactory.getRelationMapper(relation).mapToEntity(relation);
            relationEntity.setOrigin(nodeEntity);
            this.addNodeTree(relation.getDestination());
            relationEntity.setDestination(nodeRepositoryJT.getById(new NodeJTId(relation.getDestination().getNodeID().getId())));
            relationRepositoryJT.save(relationEntity);
        }
    }

    @Override
    public Node getNodeBranch(NodeId nodeId) {
        Logger.info("Node Id : {}", nodeId.getId());
        Map<NodeId, Node> nodes = new HashMap<NodeId, Node>();

        return getFullGraph(nodes, nodeId);
    }

    private Node getFullGraph(Map<NodeId, Node> nodes, NodeId id) {
        if (!nodes.containsKey(id)) {
            Logger.info("getNode -> Node Id : {}" , id.getId());
            NodeJT nodeEntity = nodeRepositoryJT.getById(new NodeJTId(id.getId()));
            Node node = NodeMapperFactory.getNodeMapper(nodeEntity).mapToDomainEntity(nodeEntity);
            nodes.put(node.getNodeID(), node);
            node.addRelations(getRelations(nodes, id));
        }
        return nodes.get(id);
    }

    private List<Relation> getRelations(Map<NodeId, Node> nodes, NodeId id) {
        List<Relation> relations = new ArrayList<>();

        for (RelationJT relationEntity : relationRepositoryJT.findAllByOriginNodeId(new NodeJTId(id.getId()))) {
            Relation relation = RelationMapperFactory.getRelationMapper(relationEntity).mapToDomainEntity(relationEntity);
            relations.add(relation);
            Logger.info("Relation Id : {}" , relation.getRelationId().getId());
            relation.setDestination(getFullGraph(nodes, new NodeId(relationEntity.getDestination().getNodeId().getId())));
        }
        return relations;
    }
}

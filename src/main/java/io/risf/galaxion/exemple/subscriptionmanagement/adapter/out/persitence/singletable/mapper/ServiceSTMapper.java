package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.NodeST;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.NodeSTId;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.ServiceST;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Node;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Service;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;

public class ServiceSTMapper implements NodeSTMapper {

    @Override
    public Node mapToDomainEntity(NodeST node) {
        Service service = Service.withId(NodeId.of(node.getNodeId().getId()));
        service.setNumber(((ServiceST)node).getNumber());

        return service;
    }

    @Override
    public NodeST mapToEntity(Node node) {
        ServiceST service = new ServiceST();

        service.setNumber(((Service)node).getNumber());
        service.setNodeId(new NodeSTId(node.getNodeID().getId()));

        return service;
    }
}
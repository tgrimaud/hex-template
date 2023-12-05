package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.NodeTPC;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.NodeTPCId;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.ServiceTPC;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Node;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Service;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;

public class ServiceTPCMapper implements NodeTPCMapper {

    @Override
    public Node mapToDomainEntity(NodeTPC node) {
        Service service = Service.withId(NodeId.of(node.getNodeId().getId()));
        service.setNumber(((ServiceTPC)node).getNumber());

        return service;
    }

    @Override
    public NodeTPC mapToEntity(Node node) {
        ServiceTPC service = new ServiceTPC();

        service.setNumber(((Service)node).getNumber());
        service.setNodeId(new NodeTPCId(node.getNodeID().getId()));

        return service;
    }
}
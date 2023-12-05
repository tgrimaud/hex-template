package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.mapper;

        import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.NodeJT;
        import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.NodeJTId;
        import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.ServiceJT;
        import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Node;
        import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;
        import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Service;

public class ServiceJTMapper implements NodeJTMapper {

    @Override
    public Node mapToDomainEntity(NodeJT node) {
        Service service = Service.withId(NodeId.of(node.getNodeId().getId()));
        service.setNumber(((ServiceJT)node).getNumber());

        return service;
    }

    @Override
    public NodeJT mapToEntity(Node node) {
        ServiceJT service = new ServiceJT();

        service.setNumber(((Service)node).getNumber());
        service.setNodeId(new NodeJTId(node.getNodeID().getId()));

        return service;
    }
}
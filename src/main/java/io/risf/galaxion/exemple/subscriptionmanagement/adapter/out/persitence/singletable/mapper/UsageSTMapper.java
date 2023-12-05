package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.NodeST;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.NodeSTId;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.UsageST;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Node;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Usage;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;

public class UsageSTMapper implements NodeSTMapper {

    @Override
    public Node mapToDomainEntity(NodeST node) {
        Usage usage = Usage.withId(NodeId.of(node.getNodeId().getId()));

        return usage;
    }

    @Override
    public NodeST mapToEntity(Node node) {
        UsageST usage = new UsageST();

        usage.setNodeId(new NodeSTId(node.getNodeID().getId()));

        return usage;
    }
}

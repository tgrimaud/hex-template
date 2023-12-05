package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.NodeJT;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.NodeJTId;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.UsageJT;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Node;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Usage;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;

public class UsageJTMapper implements NodeJTMapper {

    @Override
    public Node mapToDomainEntity(NodeJT node) {
        Usage usage = Usage.withId(NodeId.of(node.getNodeId().getId()));

        return usage;
    }

    @Override
    public NodeJT mapToEntity(Node node) {
        UsageJT usage = new UsageJT();

        usage.setNodeId(new NodeJTId(node.getNodeID().getId()));

        return usage;
    }
}

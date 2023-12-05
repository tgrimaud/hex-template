package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.NodeTPC;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.NodeTPCId;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.UsageTPC;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Node;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Usage;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;

public class UsageTPCMapper implements NodeTPCMapper {

    @Override
    public Node mapToDomainEntity(NodeTPC node) {
        Usage usage = Usage.withId(NodeId.of(node.getNodeId().getId()));

        return usage;
    }

    @Override
    public NodeTPC mapToEntity(Node node) {
        UsageTPC usage = new UsageTPC();

        usage.setNodeId(new NodeTPCId(node.getNodeID().getId()));

        return usage;
    }
}

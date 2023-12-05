package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.FeatureTPC;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.NodeTPC;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.NodeTPCId;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Feature;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Node;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;

public class FeatureTPCMapper implements NodeTPCMapper {

    @Override
    public Node mapToDomainEntity(NodeTPC node) {
        Feature feature = Feature.withId(NodeId.of(node.getNodeId().getId()));

        return feature;
    }

    @Override
    public NodeTPC mapToEntity(Node node) {
        FeatureTPC feature = new FeatureTPC();

        feature.setNodeId(new NodeTPCId(node.getNodeID().getId()));

        return feature;
    }
}

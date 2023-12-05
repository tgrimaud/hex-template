package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.NodeJT;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.NodeJTId;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.FeatureJT;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Feature;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Node;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;

public class FeatureJTMapper implements NodeJTMapper {

    @Override
    public Node mapToDomainEntity(NodeJT node) {
        Feature feature = Feature.withId(NodeId.of(node.getNodeId().getId()));

        return feature;
    }

    @Override
    public NodeJT mapToEntity(Node node) {
        FeatureJT feature = new FeatureJT();

        feature.setNodeId(new NodeJTId(node.getNodeID().getId()));

        return feature;
    }
}

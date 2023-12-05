package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.FeatureST;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.NodeST;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.NodeSTId;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Feature;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Node;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;

public class FeatureSTMapper implements NodeSTMapper {

    @Override
    public Node mapToDomainEntity(NodeST node) {
        Feature feature = Feature.withId(NodeId.of(node.getNodeId().getId()));

        return feature;
    }

    @Override
    public NodeST mapToEntity(Node node) {
        FeatureST feature = new FeatureST();

        feature.setNodeId(new NodeSTId(node.getNodeID().getId()));

        return feature;
    }
}

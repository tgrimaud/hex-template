package io.risf.galaxion.exemple.subscriptionmanagement.domain.model;

import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;

import java.time.LocalDate;

public class Feature extends Node{

    public Feature(NodeId nodeId) {
        super();
        this.setNodeID(nodeId);
    }

    public static Feature withoutId() {
        return new Feature(NodeId.nextAvailableId());
    }

    public static Feature withId(NodeId nodeId) {
        return new Feature(nodeId);
    }

    public void include(Node node) {
        this.relations.add(Included.withoutId(this, node));
    }
}

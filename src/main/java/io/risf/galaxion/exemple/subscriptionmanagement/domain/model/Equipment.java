package io.risf.galaxion.exemple.subscriptionmanagement.domain.model;

import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Equipment extends Node {
    String serialNumber;
    String partNumber;

    public Equipment(NodeId nodeId) {
        super();
        this.setNodeID(nodeId);
    }

    public static Equipment withoutId() {
        return new Equipment(NodeId.nextAvailableId());
    }

    public static Equipment withId(NodeId nodeId) {
        return new Equipment(nodeId);
    }
}

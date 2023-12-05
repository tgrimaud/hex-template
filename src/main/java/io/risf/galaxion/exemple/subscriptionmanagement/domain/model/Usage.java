package io.risf.galaxion.exemple.subscriptionmanagement.domain.model;

import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Usage extends Node {

    public Usage(NodeId nodeId) {
        super();
        this.setNodeID(nodeId);
    }

    public static Usage withoutId() {
        return new Usage(NodeId.nextAvailableId());
    }

    public static Usage withId(NodeId nodeId) {
        return new Usage(nodeId);
    }
}

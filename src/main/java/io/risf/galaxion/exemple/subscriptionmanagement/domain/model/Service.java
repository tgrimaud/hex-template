package io.risf.galaxion.exemple.subscriptionmanagement.domain.model;

import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.RelationId;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Service extends Node {
    String number;

    public Service(NodeId nodeId) {
        super();
        this.setNodeID(nodeId);
    }

    public static Service withoutId() {
        return new Service(NodeId.nextAvailableId());
    }

    public static Service withId(NodeId nodeId) {
        return new Service(nodeId);
    }

    public void include(Node node) {
        this.relations.add(Included.withoutId(this, node));
    }

    public void addAddon(Node node)  {
        AddOn addon = AddOn.withoutId(this, node);
        addon.setFromDate("today");
        this.relations.add(addon);
    }

}

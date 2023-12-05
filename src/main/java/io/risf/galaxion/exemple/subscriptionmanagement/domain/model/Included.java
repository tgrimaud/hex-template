package io.risf.galaxion.exemple.subscriptionmanagement.domain.model;

import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.RelationId;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class Included extends Relation {

    public static Included withoutId(Node origin, Node destination) {
        return new Included(RelationId.nextAvailableId(), origin, destination);
    }

    public static Included withId(RelationId relationId, Node origin, Node destination) {
        return new Included(relationId, origin, destination);
    }

    public Included(RelationId relationId, Node origin, Node destination) {
        super();
        this.relationId = relationId;
        this.origin = origin;
        this.destination = destination;
    }
}

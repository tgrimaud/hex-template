package io.risf.galaxion.exemple.subscriptionmanagement.domain.model;

import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.RelationId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddOn extends Relation {

    private String fromDate;

    public static AddOn withoutId(Node origin, Node destination) {
        return new AddOn(RelationId.nextAvailableId(), origin, destination);
    }

    public static AddOn withId(RelationId relationId, Node origin, Node destination) {
        return new AddOn(relationId, origin, destination);
    }

    public AddOn(RelationId relationId, Node origin, Node destination) {
        super();
        this.setRelationId(relationId);
        this.origin = origin;
        this.destination = destination;
    }
}

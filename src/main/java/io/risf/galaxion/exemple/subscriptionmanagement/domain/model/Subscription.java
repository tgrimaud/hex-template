package io.risf.galaxion.exemple.subscriptionmanagement.domain.model;

import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.RelationId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Subscription extends Relation {
    private LocalDate createdAt;
    private LocalDate lastUpdatedAt;
    private LocalDate terminatedAt;

    public static Subscription withoutId(Node origin, Node destination) {
        return new Subscription(RelationId.nextAvailableId(), origin, destination);
    }

    public static Subscription withId(RelationId relationId, Node origin, Node destination) {
        return new Subscription(relationId, origin, destination);
    }


    public Subscription(RelationId relationId, Node origin, Node destination) {
        super();
        this.setRelationId(relationId);
        this.origin = origin;
        this.destination = destination;
    }
}

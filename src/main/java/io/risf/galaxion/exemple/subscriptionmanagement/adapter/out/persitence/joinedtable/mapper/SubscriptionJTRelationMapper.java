package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.RelationJT;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.RelationJTId;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.SubscriptionJTRelation;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Subscription;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Relation;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.RelationId;

public class SubscriptionJTRelationMapper implements RelationJTMapper {
    @Override
    public Relation mapToDomainEntity(RelationJT relation) {
        Subscription subscription = new Subscription();

        subscription.setCreatedAt(((SubscriptionJTRelation) relation).getCreatedAt());
        subscription.setLastUpdatedAt(((SubscriptionJTRelation) relation).getLastUpdatedAt());
        subscription.setTerminatedAt(((SubscriptionJTRelation) relation).getTerminatedAt());
        subscription.setRelationId(new RelationId(relation.getRelationId().getId()));
        //subscription.setDestination();
        //subscription.setOrigin();
        return subscription;
    }

    @Override
    public RelationJT mapToEntity(Relation relation) {
        SubscriptionJTRelation subscription = new SubscriptionJTRelation();

        subscription.setCreatedAt(((Subscription) relation).getCreatedAt());
        subscription.setLastUpdatedAt(((Subscription) relation).getLastUpdatedAt());
        subscription.setTerminatedAt(((Subscription) relation).getTerminatedAt());
        subscription.setRelationId(new RelationJTId(relation.getRelationId().getId()));

        return subscription;
    }
}
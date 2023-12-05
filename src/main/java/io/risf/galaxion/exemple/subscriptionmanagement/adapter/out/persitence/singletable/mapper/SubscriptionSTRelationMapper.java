package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.RelationST;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.RelationSTId;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.SubscriptionSTRelation;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Relation;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Subscription;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.RelationId;

public class SubscriptionSTRelationMapper implements RelationSTMapper {
    @Override
    public Relation mapToDomainEntity(RelationST relation) {
        Subscription subscription = new Subscription();

        subscription.setCreatedAt(((SubscriptionSTRelation) relation).getCreatedAt());
        subscription.setLastUpdatedAt(((SubscriptionSTRelation) relation).getLastUpdatedAt());
        subscription.setTerminatedAt(((SubscriptionSTRelation) relation).getTerminatedAt());
        subscription.setRelationId(new RelationId(relation.getRelationId().getId()));
        return subscription;
    }

    @Override
    public RelationST mapToEntity(Relation relation) {
        SubscriptionSTRelation subscription = new SubscriptionSTRelation();

        subscription.setCreatedAt(((Subscription) relation).getCreatedAt());
        subscription.setLastUpdatedAt(((Subscription) relation).getLastUpdatedAt());
        subscription.setTerminatedAt(((Subscription) relation).getTerminatedAt());
        subscription.setRelationId(new RelationSTId(relation.getRelationId().getId()));

        return subscription;
    }
}
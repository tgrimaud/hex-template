package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.RelationTPC;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.RelationTPCId;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.SubscriptionTPCRelation;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Relation;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Subscription;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.RelationId;

public class SubscriptionTPCRelationMapper implements RelationTPCMapper {
    @Override
    public Relation mapToDomainEntity(RelationTPC relation) {
        Subscription subscription = new Subscription();

        subscription.setCreatedAt(((SubscriptionTPCRelation) relation).getCreatedAt());
        subscription.setLastUpdatedAt(((SubscriptionTPCRelation) relation).getLastUpdatedAt());
        subscription.setTerminatedAt(((SubscriptionTPCRelation) relation).getTerminatedAt());
        subscription.setRelationId(new RelationId(relation.getRelationId().getId()));

        return subscription;
    }

    @Override
    public RelationTPC mapToEntity(Relation relation) {
        SubscriptionTPCRelation subscription = new SubscriptionTPCRelation();

        subscription.setCreatedAt(((Subscription) relation).getCreatedAt());
        subscription.setLastUpdatedAt(((Subscription) relation).getLastUpdatedAt());
        subscription.setTerminatedAt(((Subscription) relation).getTerminatedAt());
        subscription.setRelationId(new RelationTPCId(relation.getRelationId().getId()));

        return subscription;
    }
}
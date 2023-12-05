package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.repository;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.RelationTPCId;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.SubscriptionTPCRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionTPCRelationRepository extends JpaRepository<SubscriptionTPCRelation, RelationTPCId>{
}

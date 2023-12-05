package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.repository;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.model.RelationMSCId;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.model.RelationMSC;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

@Profile("mappersuperclass")
public interface RelationRepository extends JpaRepository<RelationMSC, RelationMSCId> {
}

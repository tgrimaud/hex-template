package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.repository;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.AddOnSTRelation;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.RelationSTId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddonRelationSTRepository extends JpaRepository<AddOnSTRelation, RelationSTId>{
}

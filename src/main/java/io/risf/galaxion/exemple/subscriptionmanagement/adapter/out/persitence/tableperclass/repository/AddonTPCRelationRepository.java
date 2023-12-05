package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.repository;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.AddOnTPCRelation;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.RelationTPCId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddonTPCRelationRepository extends JpaRepository<AddOnTPCRelation, RelationTPCId>{
}

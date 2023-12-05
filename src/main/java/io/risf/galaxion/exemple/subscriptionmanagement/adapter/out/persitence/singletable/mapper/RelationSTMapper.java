package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.RelationST;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Relation;

public interface RelationSTMapper {

    Relation mapToDomainEntity(RelationST relation);

    RelationST mapToEntity(Relation relation);
}

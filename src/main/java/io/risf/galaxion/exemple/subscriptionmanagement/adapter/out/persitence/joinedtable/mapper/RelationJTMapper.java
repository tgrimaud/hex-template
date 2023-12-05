package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.RelationJT;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Relation;

public interface RelationJTMapper {

    Relation mapToDomainEntity(RelationJT relation);

    RelationJT mapToEntity(Relation relation);
}

package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.RelationTPC;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Relation;

public interface RelationTPCMapper {

    Relation mapToDomainEntity(RelationTPC relation);

    RelationTPC mapToEntity(Relation relation);
}

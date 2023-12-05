package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.IncludedTPCRelation;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.RelationTPC;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.RelationTPCId;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Included;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Relation;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.RelationId;

public class IncludedTPCRelationMapper implements RelationTPCMapper {
    @Override
    public Relation mapToDomainEntity(RelationTPC relation) {
        Included included = new Included();

        included.setRelationId(new RelationId(relation.getRelationId().getId()));

        return included;
    }

    @Override
    public RelationTPC mapToEntity(Relation relation) {
        IncludedTPCRelation included = new IncludedTPCRelation();

        included.setRelationId(new RelationTPCId(relation.getRelationId().getId()));

        return included;
    }
}
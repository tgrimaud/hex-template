package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.RelationJT;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.RelationJTId;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.IncludedJTRelation;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Included;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Relation;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.RelationId;

public class IncludedJTRelationMapper implements RelationJTMapper {
    @Override
    public Relation mapToDomainEntity(RelationJT relation) {
        Included included = new Included();

        included.setRelationId(new RelationId(relation.getRelationId().getId()));

        return included;
    }

    @Override
    public RelationJT mapToEntity(Relation relation) {
        IncludedJTRelation included = new IncludedJTRelation();

        included.setRelationId(new RelationJTId(relation.getRelationId().getId()));

        return included;
    }
}
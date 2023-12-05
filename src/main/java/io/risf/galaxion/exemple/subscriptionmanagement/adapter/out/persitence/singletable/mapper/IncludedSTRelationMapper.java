package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.IncludedSTRelation;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.RelationST;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.RelationSTId;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Included;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Relation;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.RelationId;

public class IncludedSTRelationMapper implements RelationSTMapper {
    @Override
    public Relation mapToDomainEntity(RelationST relation) {
        Included included = new Included();

        included.setRelationId(new RelationId(relation.getRelationId().getId()));

        return included;
    }

    @Override
    public RelationST mapToEntity(Relation relation) {
        IncludedSTRelation included = new IncludedSTRelation();

        included.setRelationId(new RelationSTId(relation.getRelationId().getId()));

        return included;
    }
}
package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.AddOnJTRelation;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.RelationJT;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.RelationJTId;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.AddOn;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Relation;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.RelationId;

public class AddonJTRelationMapper implements RelationJTMapper {
    @Override
    public Relation mapToDomainEntity(RelationJT relation) {
        AddOn addOn = new AddOn();
        addOn.setFromDate(((AddOnJTRelation)relation).getFromDate());
        addOn.setRelationId(new RelationId(relation.getRelationId().getId()));

        return addOn;
    }

    @Override
    public RelationJT mapToEntity(Relation relation) {
        AddOnJTRelation addOn = new AddOnJTRelation();

        addOn.setFromDate(((AddOn)relation).getFromDate());
        addOn.setRelationId(new RelationJTId(relation.getRelationId().getId()));

        return addOn;
    }
}

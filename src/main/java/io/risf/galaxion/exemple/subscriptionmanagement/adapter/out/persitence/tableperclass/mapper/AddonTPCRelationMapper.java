package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.AddOnTPCRelation;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.RelationTPC;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.RelationTPCId;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.AddOn;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Relation;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.RelationId;

public class AddonTPCRelationMapper implements RelationTPCMapper {
    @Override
    public Relation mapToDomainEntity(RelationTPC relation) {
        AddOn addOn = new AddOn();
        addOn.setFromDate(((AddOnTPCRelation)relation).getFromDate());
        addOn.setRelationId(new RelationId(relation.getRelationId().getId()));

        return addOn;
    }

    @Override
    public RelationTPC mapToEntity(Relation relation) {
        AddOnTPCRelation addOn = new AddOnTPCRelation();

        addOn.setFromDate(((AddOn)relation).getFromDate());
        addOn.setRelationId(new RelationTPCId(relation.getRelationId().getId()));

        return addOn;
    }
}

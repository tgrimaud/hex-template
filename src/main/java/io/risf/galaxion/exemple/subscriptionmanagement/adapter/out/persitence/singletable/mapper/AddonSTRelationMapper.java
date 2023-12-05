package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.AddOnSTRelation;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.RelationST;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.RelationSTId;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.AddOn;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Relation;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.RelationId;

public class AddonSTRelationMapper implements RelationSTMapper {
    @Override
    public Relation mapToDomainEntity(RelationST relation) {
        AddOn addOn = new AddOn();
        addOn.setFromDate(((AddOnSTRelation)relation).getFromDate());
        addOn.setRelationId(new RelationId(relation.getRelationId().getId()));

        return addOn;
    }

    @Override
    public RelationST mapToEntity(Relation relation) {
        AddOnSTRelation addOn = new AddOnSTRelation();

        addOn.setFromDate(((AddOn)relation).getFromDate());
        addOn.setRelationId(new RelationSTId(relation.getRelationId().getId()));

        return addOn;
    }
}

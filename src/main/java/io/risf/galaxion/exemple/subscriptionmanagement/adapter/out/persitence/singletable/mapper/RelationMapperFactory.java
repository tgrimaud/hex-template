package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.AddOnSTRelation;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.IncludedSTRelation;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.RelationST;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.SubscriptionSTRelation;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.exception.UnsuportedDomainEntityMappingException;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.AddOn;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Included;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Relation;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Subscription;

public class RelationMapperFactory {

    public static RelationSTMapper getRelationMapper(RelationST relation){
        if (relation instanceof AddOnSTRelation) {
            return new AddonSTRelationMapper();
        }
        else if (relation instanceof SubscriptionSTRelation) {
            return new SubscriptionSTRelationMapper();
        }
        else if (relation instanceof IncludedSTRelation) {
            return new IncludedSTRelationMapper();
        }
        else {
            throw new UnsuportedDomainEntityMappingException("Unknown type for Relation :" + relation.getClass().getSimpleName());
        }

    }

    public static RelationSTMapper getRelationMapper(Relation relation){
        if (relation instanceof AddOn) {
            return new AddonSTRelationMapper();
        }
        else if (relation instanceof Subscription) {
            return new SubscriptionSTRelationMapper();
        }
        else if (relation instanceof Included) {
            return new IncludedSTRelationMapper();
        }
        else {
            throw new UnsuportedDomainEntityMappingException("Unknown type for Relation :" + relation.getClass().getSimpleName());
        }

    }
}

package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.AddOnJTRelation;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.IncludedJTRelation;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.RelationJT;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.SubscriptionJTRelation;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.exception.UnsuportedDomainEntityMappingException;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.*;

public class RelationMapperFactory {

    public static RelationJTMapper getRelationMapper(RelationJT relation){
        if (relation instanceof AddOnJTRelation) {
            return new AddonJTRelationMapper();
        }
        else if (relation instanceof SubscriptionJTRelation) {
            return new SubscriptionJTRelationMapper();
        }
        else if (relation instanceof IncludedJTRelation) {
            return new IncludedJTRelationMapper();
        }
        else {
            throw new UnsuportedDomainEntityMappingException("Unknown type for Relation :" + relation.getClass().getSimpleName());
        }

    }

    public static RelationJTMapper getRelationMapper(Relation relation){
        if (relation instanceof AddOn) {
            return new AddonJTRelationMapper();
        }
        else if (relation instanceof Subscription) {
            return new SubscriptionJTRelationMapper();
        }
        else if (relation instanceof Included) {
            return new IncludedJTRelationMapper();
        }
        else {
            throw new UnsuportedDomainEntityMappingException("Unknown type for Relation :" + relation.getClass().getSimpleName());
        }

    }
}

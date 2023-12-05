package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.AddOnTPCRelation;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.IncludedTPCRelation;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.RelationTPC;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.SubscriptionTPCRelation;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.exception.UnsuportedDomainEntityMappingException;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.AddOn;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Included;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Relation;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Subscription;

public class RelationMapperFactory {

    public static RelationTPCMapper getRelationMapper(RelationTPC relation){
        if (relation instanceof AddOnTPCRelation) {
            return new AddonTPCRelationMapper();
        }
        else if (relation instanceof SubscriptionTPCRelation) {
            return new SubscriptionTPCRelationMapper();
        }
        else if (relation instanceof IncludedTPCRelation) {
            return new IncludedTPCRelationMapper();
        }
        else {
            throw new UnsuportedDomainEntityMappingException("Unknown type for Relation :" + relation.getClass().getSimpleName());
        }

    }

    public static RelationTPCMapper getRelationMapper(Relation relation){
        if (relation instanceof AddOn) {
            return new AddonTPCRelationMapper();
        }
        else if (relation instanceof Subscription) {
            return new SubscriptionTPCRelationMapper();
        }
        else if (relation instanceof Included) {
            return new IncludedTPCRelationMapper();
        }
        else {
            throw new UnsuportedDomainEntityMappingException("Unknown type for Relation :" + relation.getClass().getSimpleName());
        }

    }
}

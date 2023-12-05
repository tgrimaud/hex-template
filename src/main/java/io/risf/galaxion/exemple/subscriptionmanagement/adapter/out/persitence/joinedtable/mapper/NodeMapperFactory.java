package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.*;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.exception.UnsuportedDomainEntityMappingException;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.*;


public class NodeMapperFactory {

    public static NodeJTMapper getNodeMapper(NodeJT node){
       if (node instanceof AccountJT) {
           return new AccountJTMapper();
       }
       else if (node instanceof EquipmentJT) {
            return new EquipmentJTMapper();
       }
       else if (node instanceof ServiceJT) {
           return new ServiceJTMapper();
       }
       else if (node instanceof FeatureJT) {
           return new FeatureJTMapper();
       }
       else if (node instanceof UsageJT) {
           return new UsageJTMapper();
       }
       else {
           throw new UnsuportedDomainEntityMappingException("Unknown type for Node :" + node.getClass().getSimpleName());
       }

    }

    public static NodeJTMapper getNodeMapper(Node node){
        if (node instanceof Account) {
            return new AccountJTMapper();
        }
        else if (node instanceof Equipment) {
            return new EquipmentJTMapper();
        }
        else if (node instanceof Service) {
            return new ServiceJTMapper();
        }
        else if (node instanceof Feature) {
            return new FeatureJTMapper();
        }
        else if (node instanceof Usage) {
            return new UsageJTMapper();
        }
        else {
            throw new UnsuportedDomainEntityMappingException("Unknown type for Node :" + node.getClass().getSimpleName());
        }

    }

}

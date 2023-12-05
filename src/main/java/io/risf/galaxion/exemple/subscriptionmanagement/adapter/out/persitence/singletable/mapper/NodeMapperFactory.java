package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.*;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.exception.UnsuportedDomainEntityMappingException;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.*;


public class NodeMapperFactory {

    public static NodeSTMapper getNodeMapper(NodeST node){
       if (node instanceof AccountST) {
           return new AccountSTMapper();
       }
       else if (node instanceof EquipmentST) {
            return new EquipmentSTMapper();
       }
       else if (node instanceof ServiceST) {
           return new ServiceSTMapper();
       }
       else if (node instanceof FeatureST) {
           return new FeatureSTMapper();
       }
       else if (node instanceof UsageST) {
           return new UsageSTMapper();
       }
       else {
           throw new UnsuportedDomainEntityMappingException("Unknown type for Node :" + node.getClass().getSimpleName());
       }

    }

    public static NodeSTMapper getNodeMapper(Node node){
        if (node instanceof Account) {
            return new AccountSTMapper();
        }
        else if (node instanceof Equipment) {
            return new EquipmentSTMapper();
        }
        else if (node instanceof Service) {
            return new ServiceSTMapper();
        }
        else if (node instanceof Feature) {
            return new FeatureSTMapper();
        }
        else if (node instanceof Usage) {
            return new UsageSTMapper();
        }
        else {
            throw new UnsuportedDomainEntityMappingException("Unknown type for Node :" + node.getClass().getSimpleName());
        }

    }

}

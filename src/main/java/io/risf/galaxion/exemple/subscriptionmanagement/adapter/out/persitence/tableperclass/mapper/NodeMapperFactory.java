package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.*;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.exception.UnsuportedDomainEntityMappingException;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.*;


public class NodeMapperFactory {

    public static NodeTPCMapper getNodeMapper(NodeTPC node){
       if (node instanceof AccountTPC) {
           return new AccountTPCMapper();
       }
       else if (node instanceof EquipmentTPC) {
            return new EquipmentTPCMapper();
       }
       else if (node instanceof ServiceTPC) {
           return new ServiceTPCMapper();
       }
       else if (node instanceof FeatureTPC) {
           return new FeatureTPCMapper();
       }
       else if (node instanceof UsageTPC) {
           return new UsageTPCMapper();
       }
       else {
           throw new UnsuportedDomainEntityMappingException("Unknown type for Node :" + node.getClass().getSimpleName());
       }

    }

    public static NodeTPCMapper getNodeMapper(Node node){
        if (node instanceof Account) {
            return new AccountTPCMapper();
        }
        else if (node instanceof Equipment) {
            return new EquipmentTPCMapper();
        }
        else if (node instanceof Service) {
            return new ServiceTPCMapper();
        }
        else if (node instanceof Feature) {
            return new FeatureTPCMapper();
        }
        else if (node instanceof Usage) {
            return new UsageTPCMapper();
        }
        else {
            throw new UnsuportedDomainEntityMappingException("Unknown type for Node :" + node.getClass().getSimpleName());
        }

    }

}

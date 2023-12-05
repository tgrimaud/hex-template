package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.repository;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.model.ServiceMSC;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.model.NodeMSCId;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

@Profile("mappersuperclass")
public interface ServiceRepository extends JpaRepository<ServiceMSC, NodeMSCId>, JpaSpecificationExecutor<ServiceMSC> {
}

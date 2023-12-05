package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.repository;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.NodeTPCId;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.ServiceTPC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ServiceTPCRepository extends JpaRepository<ServiceTPC, NodeTPCId>, JpaSpecificationExecutor<ServiceTPC> {
}

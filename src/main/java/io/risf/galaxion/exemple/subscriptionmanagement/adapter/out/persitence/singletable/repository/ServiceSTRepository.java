package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.repository;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.NodeSTId;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.ServiceST;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ServiceSTRepository extends JpaRepository<ServiceST, NodeSTId>, JpaSpecificationExecutor<ServiceST> {
}

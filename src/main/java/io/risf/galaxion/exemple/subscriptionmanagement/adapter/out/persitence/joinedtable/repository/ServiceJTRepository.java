package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.repository;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.NodeJTId;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.ServiceJT;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
@Profile("joinedtable")
public interface ServiceJTRepository extends JpaRepository<ServiceJT, NodeJTId>, JpaSpecificationExecutor<ServiceJT> {
}

package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.repository;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.model.NodeMSC;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.model.NodeMSCId;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

@Profile("mappersuperclass")
public interface NodeRepository extends JpaRepository<NodeMSC, NodeMSCId> {
}

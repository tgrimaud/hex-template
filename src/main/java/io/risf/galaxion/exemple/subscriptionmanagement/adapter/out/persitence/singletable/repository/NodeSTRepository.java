package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.repository;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.NodeST;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.NodeSTId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeSTRepository extends JpaRepository<NodeST, NodeSTId> {
}


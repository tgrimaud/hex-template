package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.repository;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.NodeST;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.RelationST;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.RelationSTId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RelationSTRepository extends JpaRepository<RelationST, RelationSTId> {

    public List<RelationST> findAllByOrigin(NodeST origin);
}

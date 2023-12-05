package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.repository;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.NodeTPC;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.RelationTPC;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.RelationTPCId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RelationTPCRepository  extends JpaRepository<RelationTPC, RelationTPCId> {
    public List<RelationTPC> findAllByOrigin(NodeTPC origin);
}

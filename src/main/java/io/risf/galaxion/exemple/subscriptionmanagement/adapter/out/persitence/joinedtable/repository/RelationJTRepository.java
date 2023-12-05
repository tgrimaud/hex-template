package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.repository;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.NodeJT;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.NodeJTId;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.RelationJT;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.RelationJTId;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("joinedtable")
public interface RelationJTRepository extends JpaRepository<RelationJT, RelationJTId> {

    public List<RelationJT> findAllByOriginNodeId(NodeJTId origin);
}

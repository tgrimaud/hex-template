package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.NodeJT;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Node;

public interface NodeJTMapper {

    Node mapToDomainEntity(NodeJT node);

    NodeJT mapToEntity(Node node);
}

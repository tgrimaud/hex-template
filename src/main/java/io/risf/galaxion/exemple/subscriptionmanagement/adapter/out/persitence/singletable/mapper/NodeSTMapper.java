package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.NodeST;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Node;

public interface NodeSTMapper {

    Node mapToDomainEntity(NodeST node);

    NodeST mapToEntity(Node node);
}

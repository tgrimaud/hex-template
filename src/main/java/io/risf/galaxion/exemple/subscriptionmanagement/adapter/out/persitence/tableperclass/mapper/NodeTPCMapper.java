package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.NodeTPC;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Node;

public interface NodeTPCMapper {

    Node mapToDomainEntity(NodeTPC node);

    NodeTPC mapToEntity(Node node);
}

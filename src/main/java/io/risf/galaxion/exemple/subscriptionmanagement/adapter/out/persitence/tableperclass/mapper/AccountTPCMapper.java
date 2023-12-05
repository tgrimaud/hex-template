package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.AccountTPC;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.NodeTPC;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.NodeTPCId;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Account;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Node;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;

public class AccountTPCMapper implements NodeTPCMapper {

    @Override
    public Node mapToDomainEntity(NodeTPC node) {
        Account account = Account.withId(NodeId.of(node.getNodeId().getId()));
        account.setLastName(((AccountTPC)node).getLastName());
        account.setFirstName(((AccountTPC)node).getFirstName());

        return account;
    }

    @Override
    public NodeTPC mapToEntity(Node node) {
        AccountTPC account = new AccountTPC();

        account.setLastName(((Account)node).getLastName());
        account.setFirstName(((Account)node).getFirstName());
        account.setNodeId(new NodeTPCId(node.getNodeID().getId()));

        return account;
    }
}

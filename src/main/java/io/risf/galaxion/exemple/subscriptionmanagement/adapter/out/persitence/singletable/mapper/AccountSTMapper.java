package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.AccountST;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.NodeST;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.NodeSTId;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Account;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Node;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;

public class AccountSTMapper implements NodeSTMapper {

    @Override
    public Node mapToDomainEntity(NodeST node) {
        Account account = Account.withId(NodeId.of(node.getNodeId().getId()));
        account.setLastName(((AccountST)node).getLastName());
        account.setFirstName(((AccountST)node).getFirstName());

        return account;
    }

    @Override
    public NodeST mapToEntity(Node node) {
        AccountST account = new AccountST();

        account.setLastName(((Account)node).getLastName());
        account.setFirstName(((Account)node).getFirstName());
        account.setNodeId(new NodeSTId(node.getNodeID().getId()));

        return account;
    }
}

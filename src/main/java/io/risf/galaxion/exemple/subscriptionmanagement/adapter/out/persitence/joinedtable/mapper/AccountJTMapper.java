package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.mapper;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.AccountJT;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.NodeJT;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.NodeJTId;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Account;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Node;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;

public class AccountJTMapper implements NodeJTMapper {

    @Override
    public Node mapToDomainEntity(NodeJT node) {
        Account account = Account.withId(NodeId.of(node.getNodeId().getId()));
        account.setLastName(((AccountJT)node).getLastName());
        account.setFirstName(((AccountJT)node).getFirstName());

        return account;
    }

    @Override
    public NodeJT mapToEntity(Node node) {
        AccountJT account = new AccountJT();

        account.setLastName(((Account)node).getLastName());
        account.setFirstName(((Account)node).getFirstName());
        account.setNodeId(new NodeJTId(node.getNodeID().getId()));

        return account;
    }
}

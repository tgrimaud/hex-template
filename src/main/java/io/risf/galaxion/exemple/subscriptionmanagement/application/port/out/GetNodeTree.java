package io.risf.galaxion.exemple.subscriptionmanagement.application.port.out;

import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.Node;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;

public interface GetNodeTree {

    public Node getNodeBranch(NodeId id);

}

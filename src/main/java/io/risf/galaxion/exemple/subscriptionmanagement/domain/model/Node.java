package io.risf.galaxion.exemple.subscriptionmanagement.domain.model;

import io.risf.galaxion.exemple.accountmanagement.domain.model.Account;
import io.risf.galaxion.exemple.accountmanagement.domain.model.AccountId;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.id.NodeId;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class  Node {
    NodeId nodeID;
    List<Relation> relations = new ArrayList<>();

    public void addRelations(List<Relation> relations) {
        this.relations.addAll(relations);
    }
}

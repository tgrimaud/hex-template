package io.risf.galaxion.exemple.subscriptionmanagement.application.service;

import io.risf.galaxion.exemple.subscriptionmanagement.application.port.in.CreateSubscriptionCommand;
import io.risf.galaxion.exemple.subscriptionmanagement.application.port.in.CreateSubscriptionUseCase;
import io.risf.galaxion.exemple.subscriptionmanagement.application.port.out.AddEquipmentAndService;
import io.risf.galaxion.exemple.subscriptionmanagement.application.port.out.AddNodeTree;
import io.risf.galaxion.exemple.subscriptionmanagement.application.port.out.GetNodeTree;
import io.risf.galaxion.exemple.subscriptionmanagement.domain.model.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateSubscriptionApplicationService implements CreateSubscriptionUseCase {

    private final AddEquipmentAndService addEquipmentAndService;
    private final AddNodeTree addNodeTree;
    private final GetNodeTree getNodeTree;

    private static org.slf4j.Logger Logger = LoggerFactory
            .getLogger(CreateSubscriptionApplicationService.class);

    public void createSubscription(CreateSubscriptionCommand command) {
        Logger.info("Create Sub for Account with FirstName : {} and LastName : {}", command.firstName(), command.lastName());

        Node account = GraphBuilder.buildAccountGraphWithDoubleRelation(command.firstName(), command.lastName());
        addNodeTree.addNodeTree(account);

        Logger.info("Create Sub for Account with Id {}", account.getNodeID().getId());
        Node nodeTree = getNodeTree.getNodeBranch(account.getNodeID());
        if (nodeTree instanceof Account) {
            Logger.info("Account firstName {} lastName {}",((Account)nodeTree).getFirstName(), ((Account)nodeTree).getLastName());
        }

    }
}

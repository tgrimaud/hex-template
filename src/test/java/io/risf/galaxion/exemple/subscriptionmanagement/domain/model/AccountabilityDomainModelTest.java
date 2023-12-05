package io.risf.galaxion.exemple.subscriptionmanagement.domain.model;

import io.risf.galaxion.exemple.TemplateApplicationTest;
import io.risf.galaxion.exemple.subscriptionmanagement.application.port.out.AddNodeTree;
import io.risf.galaxion.exemple.subscriptionmanagement.application.port.out.GetNodeTree;
import io.risf.galaxion.exemple.subscriptionmanagement.application.service.GraphBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;


@SpringBootTest(classes = TemplateApplicationTest.class)
@ActiveProfiles({"test", "joinedtable"})
public class AccountabilityDomainModelTest {

    @Autowired
    private AddNodeTree addNodeTree;

    @Autowired
    private GetNodeTree getNodeTree;

    @Test
    public void buildAnAccountWithOneSubOfOneServiceAndOneEquipment() {
        Account account = Account.withoutId();

        account.setFirstName("Bob");
        account.setLastName("Sponge");

        Service service = Service.withoutId();
        service.setNumber("696969696969");

        Equipment equipment = Equipment.withoutId();
        equipment.setPartNumber("myPartNumber");
        equipment.setSerialNumber("myPartNumber");

        Usage usage = Usage.withoutId();

        service.include(equipment);
        service.addAddon(usage);

        Feature feature = Feature.withoutId();

        account.subscribe(service);
        account.addAddon(feature);

        Assertions.assertTrue(account.relations.size() == 2);
        Assertions.assertTrue(account.getSubscriptions().size() == 1);
        Assertions.assertTrue(account.getAddOns().size() == 1);

    }

    @Test
    public void AddTestAccountNode() {
        Node account = GraphBuilder.buildAccountGraph();
        addNodeTree.addNodeTree(account);

    }

    @Test
    public void AddTestAccountNodeWithDoubleRelation() {
        Node account = GraphBuilder.buildAccountGraphWithDoubleRelation();

        addNodeTree.addNodeTree(account);
        getNodeTree.getNodeBranch(account.getNodeID());
    }

}

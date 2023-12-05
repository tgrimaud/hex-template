package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence;

import io.risf.galaxion.exemple.TemplateApplicationTest;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.*;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.repository.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = TemplateApplicationTest.class)
@SpringBootTest(classes = TemplateApplicationTest.class)
@ActiveProfiles({"test", "joinedtable"})
public class AccountabilityJTModelTest {
    @Autowired
    private EquipmentJTRepository equipmentRepository;

    @Autowired
    private ServiceJTRepository serviceRepository;

    @Autowired
    private NodeJTRepository nodeRepository;

    @Autowired
    private AddonJTRelationRepository addonRepository;

    @Autowired
    private RelationJTRepository relationRepository;

    @Test
    public void givenJTSubclasses_whenQuerySingleTableSuperclass_thenOk() {
        EquipmentJT equipment = new EquipmentJT();
        NodeJTId equipmentId = new NodeJTId();
        equipmentId.setId("1L");
        equipment.setSerialNumber("Test Equipment 1");
        equipment.setPartNumber("Type 1");
        equipment.setNodeId(equipmentId);
        equipmentRepository.save(equipment);

        ServiceJT service = new ServiceJT();
        service.setNumber("Test Service 1");
        NodeJTId serviceId = new NodeJTId();
        serviceId.setId("2L");
        service.setNodeId(serviceId);
        serviceRepository.save(service);

        Assertions.assertTrue(nodeRepository.findAll().size() ==2 );
    }

    @Test
    public void givenJTSubclasses_whenQuerySingleTableSuperclass_thenOk_usingSuperClassRepo(){
        EquipmentJT equipment = new EquipmentJT();
        NodeJTId equipmentId = new NodeJTId();
        equipmentId.setId("1L");
        equipment.setSerialNumber("Test Equipment 1");
        equipment.setPartNumber("Type 1");
        equipment.setNodeId(equipmentId);
        nodeRepository.save(equipment);

        ServiceJT service = new ServiceJT();
        service.setNumber("Test Service 1");
        NodeJTId serviceId = new NodeJTId();
        serviceId.setId("2L");
        service.setNodeId(serviceId);
        nodeRepository.save(service);

        Assertions.assertTrue(nodeRepository.findAll().size() ==2 );

        AddOnJTRelation addon = new AddOnJTRelation();
        addon.setOrigin(service);
        addon.setDestination(equipment);
        RelationJTId addonId = new RelationJTId();
        addonId.setId("1L");
        addon.setRelationId(addonId);

        relationRepository.save(addon);

        Assertions.assertTrue(relationRepository.findAll().size() == 1 );

        RelationJT relation = relationRepository.getById(new RelationJTId("1L"));

        Assertions.assertTrue(relation instanceof AddOnJTRelation);
        Assertions.assertTrue((relation.getOrigin() instanceof ServiceJT));
        Assertions.assertTrue((relation.getDestination() instanceof EquipmentJT));
    }
}
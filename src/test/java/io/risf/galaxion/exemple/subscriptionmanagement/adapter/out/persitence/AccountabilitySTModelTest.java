package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence;

import io.risf.galaxion.exemple.TemplateApplicationTest;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.*;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.repository.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes = TemplateApplicationTest.class)
@ActiveProfiles({"test", "singletable"})
public class AccountabilitySTModelTest {
    @Autowired
    private EquipmentSTRepository equipmentRepository;

    @Autowired
    private ServiceSTRepository serviceRepository;

    @Autowired
    private NodeSTRepository nodeRepository;

    @Autowired
    private AddonRelationSTRepository addonRepository;

    @Autowired
    private RelationSTRepository relationRepository;

    @Test
    public void givenSTSubclasses_whenQuerySingleTableSuperclass_thenOk() {
        EquipmentST equipment = new EquipmentST();
        NodeSTId equipmentId = new NodeSTId();
        equipmentId.setId("1L");
        equipment.setSerialNumber("Test Equipment 1");
        equipment.setPartNumber("Type 1");
        equipment.setNodeId(equipmentId);
        equipmentRepository.save(equipment);

        ServiceST service = new ServiceST();
        service.setNumber("Test Service 1");
        NodeSTId serviceId = new NodeSTId();
        serviceId.setId("2L");
        service.setNodeId(serviceId);
        serviceRepository.save(service);

        Assertions.assertTrue(nodeRepository.findAll().size() ==2 );
    }

    @Test
    public void givenSTSubclasses_whenQuerySingleTableSuperclass_thenOk_usingSuperClassRepo(){
        EquipmentST equipment = new EquipmentST();
        NodeSTId equipmentId = new NodeSTId();
        equipmentId.setId("1L");
        equipment.setSerialNumber("Test Equipment 1");
        equipment.setPartNumber("Type 1");
        equipment.setNodeId(equipmentId);
        nodeRepository.save(equipment);

        ServiceST service = new ServiceST();
        service.setNumber("Test Service 1");
        NodeSTId serviceId = new NodeSTId();
        serviceId.setId("2L");
        service.setNodeId(serviceId);
        nodeRepository.save(service);

        Assertions.assertTrue(nodeRepository.findAll().size() ==2 );

        AddOnSTRelation addon = new AddOnSTRelation();
        addon.setOrigin(service);
        addon.setDestination(equipment);
        RelationSTId addonId = new RelationSTId();
        addonId.setId("1L");
        addon.setRelationId(addonId);

        relationRepository.save(addon);

        Assertions.assertTrue(relationRepository.findAll().size() == 1 );

        RelationST relation = relationRepository.getById(new RelationSTId("1L"));

        Assertions.assertTrue(relation instanceof AddOnSTRelation);
        Assertions.assertTrue((relation.getOrigin() instanceof  ServiceST));
        Assertions.assertTrue((relation.getDestination() instanceof  EquipmentST));
    }
}
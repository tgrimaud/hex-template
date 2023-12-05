package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence;

import io.risf.galaxion.exemple.TemplateApplicationTest;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.*;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.repository.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TemplateApplicationTest.class)
@ActiveProfiles({"test", "tableperclass"})
public class AccountabilityTPCModelTest {

    @Autowired
    private EquipmentTPCRepository equipmentRepository;

    @Autowired
    private ServiceTPCRepository serviceRepository;

    @Autowired
    private NodeTPCRepository nodeRepository;

    @Autowired
    private AddonTPCRelationRepository addonRepository;

    @Autowired
    private RelationTPCRepository relationRepository;

    @Test
    public void givenTPCSubclasses_whenQuerySingleTableSuperclass_thenOk() {
        EquipmentTPC equipment = new EquipmentTPC();
        NodeTPCId equipmentId = new NodeTPCId();
        equipmentId.setId("1L");
        equipment.setSerialNumber("Test Equipment 1");
        equipment.setPartNumber("Type 1");
        equipment.setNodeId(equipmentId);
        equipmentRepository.save(equipment);

        ServiceTPC service = new ServiceTPC();
        service.setNumber("Test Service 1");
        NodeTPCId serviceId = new NodeTPCId();
        serviceId.setId("2L");
        service.setNodeId(serviceId);
        serviceRepository.save(service);

        Assertions.assertTrue(nodeRepository.findAll().size() ==2 );
    }

    @Test
    public void givenTPCSubclasses_whenQuerySingleTableSuperclass_thenOk_usingSuperClassRepo(){
        EquipmentTPC equipment = new EquipmentTPC();
        NodeTPCId equipmentId = new NodeTPCId();
        equipmentId.setId("1L");
        equipment.setSerialNumber("Test Equipment 1");
        equipment.setPartNumber("Type 1");
        equipment.setNodeId(equipmentId);
        nodeRepository.save(equipment);

        ServiceTPC service = new ServiceTPC();
        service.setNumber("Test Service 1");
        NodeTPCId serviceId = new NodeTPCId();
        serviceId.setId("2L");
        service.setNodeId(serviceId);
        nodeRepository.save(service);

        Assertions.assertTrue(nodeRepository.findAll().size() ==2 );

        AddOnTPCRelation addon = new AddOnTPCRelation();
        addon.setOrigin(service);
        addon.setDestination(equipment);
        RelationTPCId addonId = new RelationTPCId();
        addonId.setId("1L");
        addon.setRelationId(addonId);

        relationRepository.save(addon);

        Assertions.assertTrue(relationRepository.findAll().size() == 1 );

        RelationTPC relation = relationRepository.getById(new RelationTPCId("1L"));

        Assertions.assertTrue(relation instanceof AddOnTPCRelation);
        Assertions.assertTrue((relation.getOrigin() instanceof  ServiceTPC));
        Assertions.assertTrue((relation.getDestination() instanceof  EquipmentTPC));
    }
}

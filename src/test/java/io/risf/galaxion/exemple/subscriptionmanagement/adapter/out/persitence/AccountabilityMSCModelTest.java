package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence;

import io.risf.galaxion.exemple.TemplateApplicationTest;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.model.EquipmentMSC;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.model.NodeMSCId;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.model.ServiceMSC;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.repository.EquipmentRepository;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.repository.NodeRepository;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.repository.ServiceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@ContextConfiguration(classes = TemplateApplicationTest.class)
@ActiveProfiles({"test", "mappersuperclass"})
public class AccountabilityMSCModelTest {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private NodeRepository nodeRepository;

    @Test
    public void givenMSCSubclasses_whenQuerySingleTableSuperclass_thenExceptionIsRaised() {
        Assertions.assertThrows(InvalidDataAccessApiUsageException.class,
                ()->{
                EquipmentMSC equipment = new EquipmentMSC();
                NodeMSCId equipmentId = new NodeMSCId();
                equipmentId.setId("1L");
                equipment.setDescription("Test Equipment 1");
                equipment.setType("Type 1");
                equipment.setId(equipmentId);
                equipmentRepository.save(equipment);

                ServiceMSC service = new ServiceMSC();
                service.setName("Test Service 1");
                NodeMSCId serviceId = new NodeMSCId();
                serviceId.setId("2L");
                service.setId(serviceId);
                serviceRepository.save(service);

                nodeRepository.findAll().size();
        } );
    }
}

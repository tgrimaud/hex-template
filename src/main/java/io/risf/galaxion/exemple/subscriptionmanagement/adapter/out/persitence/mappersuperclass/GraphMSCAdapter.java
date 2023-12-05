package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.repository.EquipmentRepository;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.repository.NodeRepository;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.repository.ServiceRepository;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.mappersuperclass.model.*;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.model.*;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.repository.RelationRepository;
import io.risf.galaxion.exemple.subscriptionmanagement.application.port.out.AddEquipmentAndService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Getter
@Component
@RequiredArgsConstructor
@Profile("mappersuperclass")
public class GraphMSCAdapter implements AddEquipmentAndService {
    private static org.slf4j.Logger Logger = LoggerFactory.getLogger(GraphMSCAdapter.class);

    private final EquipmentRepository equipmentRepositoryMSC;
    private final ServiceRepository serviceRepositoryMSC;
    private final NodeRepository nodeRepositoryMSC;
    private final RelationRepository relationRepositoryMSC;

    public void addEquipmentAndServiceNodes(){
        EquipmentMSC equipment = new EquipmentMSC();
        NodeMSCId equipmentId = new NodeMSCId();
        equipmentId.setId("1L");
        equipment.setDescription("Test Equipment 1");
        equipment.setType("Type 1");
        equipment.setId(equipmentId);
        nodeRepositoryMSC.save(equipment);

        EquipmentMSC equipment2 = new EquipmentMSC();
        NodeMSCId equipmentId2 = new NodeMSCId();
        equipmentId2.setId("2L");
        equipment2.setDescription("Test Equipment 2");
        equipment2.setType("Type 2");
        equipment2.setId(equipmentId);
        nodeRepositoryMSC.save(equipment);


        AddOnMSCRelation addon = new AddOnMSCRelation();
        addon.setOrigin(equipment2);
        addon.setDestination(equipment);
        RelationMSCId addonId = new RelationMSCId();
        addonId.setId("1L");
        addon.setId(addonId);

        relationRepositoryMSC.save(addon);

        RelationMSC relation = relationRepositoryMSC.getById(new RelationMSCId("1L"));

        Logger.info("Nb Node Entries MSC {}", nodeRepositoryMSC.findAll().size());
    }
}

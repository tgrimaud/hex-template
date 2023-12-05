package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.repository;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.model.EquipmentMSC;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.mappersuperclass.model.NodeMSCId;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("mappersuperclass")
public interface EquipmentRepository extends JpaRepository<EquipmentMSC, NodeMSCId>  {

}

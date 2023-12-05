package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.repository;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.EquipmentTPC;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.tableperclass.model.NodeTPCId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentTPCRepository extends JpaRepository<EquipmentTPC, NodeTPCId>  {

}

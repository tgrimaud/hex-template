package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.repository;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.EquipmentST;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.singletable.model.NodeSTId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentSTRepository extends JpaRepository<EquipmentST, NodeSTId>  {

}

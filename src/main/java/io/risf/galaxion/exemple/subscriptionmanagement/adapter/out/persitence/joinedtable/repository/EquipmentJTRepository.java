package io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.repository;

import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.EquipmentJT;
import io.risf.galaxion.exemple.subscriptionmanagement.adapter.out.persitence.joinedtable.model.NodeJTId;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("joinedtable")
public interface EquipmentJTRepository extends JpaRepository<EquipmentJT, NodeJTId>  {

}

package com.CRUD.demoCRUD.repository;

import com.CRUD.demoCRUD.entity.SimMobileCarrier;
import com.CRUD.demoCRUD.entity.SimMobileCarrierConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimMobileCarrierConfigRepository extends JpaRepository<SimMobileCarrierConfig,Long> {

}

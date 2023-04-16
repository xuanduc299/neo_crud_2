package com.CRUD.demoCRUD.repository;

import com.CRUD.demoCRUD.entity.SimMobileCarrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimMobileCarrierRepository extends JpaRepository<SimMobileCarrier,Long> {
    SimMobileCarrier existsByName(String name);
    SimMobileCarrier getById(Long id);
}

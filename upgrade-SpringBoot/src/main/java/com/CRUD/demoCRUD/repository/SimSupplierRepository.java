package com.CRUD.demoCRUD.repository;

import com.CRUD.demoCRUD.entity.SimSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimSupplierRepository extends JpaRepository<SimSupplier,Long> {
    SimSupplier getById(Long id);
}

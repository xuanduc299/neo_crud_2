package com.CRUD.demoCRUD.repository;

import com.CRUD.demoCRUD.entity.Ward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WardRepository extends JpaRepository<Ward, Integer> {
}

package com.CRUD.demoCRUD.repository;

import com.CRUD.demoCRUD.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistrictRepository extends JpaRepository<District,Integer> {
}

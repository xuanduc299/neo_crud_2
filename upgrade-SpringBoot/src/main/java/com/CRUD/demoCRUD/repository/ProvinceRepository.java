package com.CRUD.demoCRUD.repository;

import com.CRUD.demoCRUD.entity.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvinceRepository extends JpaRepository<Province, Integer> {
}

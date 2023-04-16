package com.CRUD.demoCRUD.service;

import com.CRUD.demoCRUD.dto.SimSupplierDTO;
import com.CRUD.demoCRUD.entity.SimSupplier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SimSupplierService extends IRootService<SimSupplierDTO>{
    public List<SimSupplierDTO> getAll();
    public SimSupplierDTO getById(Long id);

}

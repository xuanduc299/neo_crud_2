package com.CRUD.demoCRUD.service;

import com.CRUD.demoCRUD.dto.SimMobileCarrierDTO;
import com.CRUD.demoCRUD.dto.SimSupplierDTO;
import com.CRUD.demoCRUD.entity.SimMobileCarrier;
import com.CRUD.demoCRUD.entity.SimSupplier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SimMobileCarrierService extends IRootService<SimMobileCarrierDTO>{
    public List<SimMobileCarrierDTO> getAll();
    public SimMobileCarrierDTO getById(Long id);
}

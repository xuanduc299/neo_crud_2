package com.CRUD.demoCRUD.service;

import com.CRUD.demoCRUD.dto.SimMobileCarrierConfigDTO;
import com.CRUD.demoCRUD.dto.SimSupplierDTO;
import com.CRUD.demoCRUD.entity.SimMobileCarrier;
import com.CRUD.demoCRUD.entity.SimMobileCarrierConfig;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SimMobileCarrierConfigService extends IRootService<SimMobileCarrierConfigDTO>{
    public List<SimMobileCarrierConfigDTO> getAll();
}

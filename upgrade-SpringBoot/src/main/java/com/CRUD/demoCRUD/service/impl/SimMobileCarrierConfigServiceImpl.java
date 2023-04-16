package com.CRUD.demoCRUD.service.impl;

import com.CRUD.demoCRUD.convert.SimMobileCarrierConfigConvert;
import com.CRUD.demoCRUD.convert.SimSupplierConvert;
import com.CRUD.demoCRUD.dto.SimMobileCarrierConfigDTO;
import com.CRUD.demoCRUD.dto.SimMobileCarrierDTO;
import com.CRUD.demoCRUD.entity.SimMobileCarrier;
import com.CRUD.demoCRUD.entity.SimMobileCarrierConfig;
import com.CRUD.demoCRUD.repository.SimMobileCarrierConfigRepository;
import com.CRUD.demoCRUD.repository.SimMobileCarrierRepository;
import com.CRUD.demoCRUD.service.SimMobileCarrierConfigService;
import com.CRUD.demoCRUD.service.SimMobileCarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimMobileCarrierConfigServiceImpl implements SimMobileCarrierConfigService {

    @Autowired
    private SimMobileCarrierConfigRepository simMobileCarrierConfigRepository;

    @Autowired
    private SimMobileCarrierConfigConvert convert;

    @Override
    public SimMobileCarrierConfigDTO create(SimMobileCarrierConfigDTO entity) {
        SimMobileCarrierConfig simMobileCarrierConfig = new SimMobileCarrierConfig();
        convert.convertDataIntoDTO(entity,simMobileCarrierConfig);
        simMobileCarrierConfig = simMobileCarrierConfigRepository.save(simMobileCarrierConfig);
        return new SimMobileCarrierConfigDTO(simMobileCarrierConfig);
    }

    @Override
    public SimMobileCarrierConfigDTO retrieve(Long id) {
        return null;
    }

    @Override
    public SimMobileCarrierConfigDTO update(SimMobileCarrierConfigDTO entity, Long id) {
        return null;
    }
    @Override
    public void delete(Long id) {

    }
    @Override
    public List<SimMobileCarrierConfigDTO> getAll() {
        List<SimMobileCarrierConfig> simMobileCarrierConfig =  simMobileCarrierConfigRepository.findAll();
        List<SimMobileCarrierConfigDTO> mobileCarrierConfigDTO  = new ArrayList<>();
        simMobileCarrierConfigRepository.findAll().forEach(simMobileCarrierConfigs -> mobileCarrierConfigDTO.add(new SimMobileCarrierConfigDTO(simMobileCarrierConfigs)));
        return mobileCarrierConfigDTO;
    }
}

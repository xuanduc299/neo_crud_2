package com.CRUD.demoCRUD.service.impl;

import com.CRUD.demoCRUD.convert.SimMobileCarrierConvert;
import com.CRUD.demoCRUD.dto.SimMobileCarrierDTO;
import com.CRUD.demoCRUD.dto.SimSupplierDTO;
import com.CRUD.demoCRUD.entity.SimMobileCarrier;
import com.CRUD.demoCRUD.entity.SimSupplier;
import com.CRUD.demoCRUD.repository.SimMobileCarrierRepository;
import com.CRUD.demoCRUD.service.SimMobileCarrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimMobileCarrierServiceImpl implements SimMobileCarrierService {

    @Autowired
    private SimMobileCarrierRepository simMobileCarrierRepository;

    @Autowired
    private SimMobileCarrierConvert convert;

    @Override
    public SimMobileCarrierDTO create(SimMobileCarrierDTO entity) {
        SimMobileCarrier simMobileCarrier = new SimMobileCarrier();
        convert.convertDataIntoDTO(entity,simMobileCarrier);
        simMobileCarrier = simMobileCarrierRepository.save(simMobileCarrier);
        return new SimMobileCarrierDTO(simMobileCarrier);
    }

    @Override
    public SimMobileCarrierDTO retrieve(Long id) {
        return null;
    }

    @Override
    public SimMobileCarrierDTO update(SimMobileCarrierDTO entity, Long id) {
        SimMobileCarrier exists = simMobileCarrierRepository.existsByName(entity.getName());
        if (exists!=null) {
            // Thực hiện update
            SimMobileCarrier SimMobileCarriers = simMobileCarrierRepository.getById(id);
            convert.convertDataIntoDTO(entity,SimMobileCarriers);
            SimMobileCarriers = simMobileCarrierRepository.save(SimMobileCarriers);
            return new SimMobileCarrierDTO(SimMobileCarriers);
        } else {
            // Thực hiện insert
            SimMobileCarrier simMobileCarrier = new SimMobileCarrier();
            convert.convertDataIntoDTO(entity,simMobileCarrier);
            simMobileCarrier = simMobileCarrierRepository.save(simMobileCarrier);
            return new SimMobileCarrierDTO(simMobileCarrier);
        }
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<SimMobileCarrierDTO> getAll() {
//        List<SimMobileCarrier> simMobileCarrier =  simMobileCarrierRepository.findAll();
//        List<SimMobileCarrierDTO> mobileCarrierDTO = new ArrayList<>();
//        simMobileCarrierRepository.findAll().forEach(simMobileCarriers -> mobileCarrierDTO.add(new SimMobileCarrierDTO(simMobileCarriers)));
//        return mobileCarrierDTO;
        List<SimMobileCarrier> simMobileCarrier = simMobileCarrierRepository.findAll();
        List<SimMobileCarrierDTO> mobileCarrierDTO = convert.toListDTO(simMobileCarrier);
        return mobileCarrierDTO;
    }

    @Override
    public SimMobileCarrierDTO getById(Long id) {
        SimMobileCarrier simSupplier = simMobileCarrierRepository.getById(id);
        return new SimMobileCarrierDTO(simSupplier);
    }
}

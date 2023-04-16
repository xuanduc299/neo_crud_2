package com.CRUD.demoCRUD.service.impl;

import com.CRUD.demoCRUD.convert.SimSupplierConvert;
import com.CRUD.demoCRUD.dto.SimSupplierDTO;
import com.CRUD.demoCRUD.entity.SimMobileCarrier;
import com.CRUD.demoCRUD.entity.SimSupplier;
import com.CRUD.demoCRUD.repository.SimSupplierRepository;
import com.CRUD.demoCRUD.service.SimSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimSupplierServiceImpl implements SimSupplierService {

    @Autowired
    private SimSupplierRepository simSupplierRepository;

    @Autowired
    private SimSupplierConvert convert;

    @Override
    public SimSupplierDTO create(SimSupplierDTO entity) {
        SimSupplier simSupplier = new SimSupplier();
        convert.convertDataIntoDTO(entity,simSupplier);
        simSupplier = simSupplierRepository.save(simSupplier);
        return new SimSupplierDTO(simSupplier);
    }

    @Override
    public SimSupplierDTO retrieve(Long id) {
        return null;
    }

    @Override
    public SimSupplierDTO update(SimSupplierDTO entity, Long id) {
        if (entity == null){
            SimSupplier simSuppliers = new SimSupplier();
            convert.convertDataIntoDTO(entity,simSuppliers);
            simSuppliers = simSupplierRepository.save(simSuppliers);
            return new SimSupplierDTO(simSuppliers);
        }else {
            SimSupplier simSupplier = simSupplierRepository.getById(id);
            convert.convertDataIntoDTO(entity,simSupplier);
            simSupplier = simSupplierRepository.save(simSupplier);
            return new SimSupplierDTO(simSupplier);
        }
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<SimSupplierDTO> getAll() {
        List<SimSupplier> simSupplier =  simSupplierRepository.findAll();
        List<SimSupplierDTO> simSupplierDTO = new ArrayList<>();
        simSupplierRepository.findAll().forEach(simSuppliers -> simSupplierDTO.add(new SimSupplierDTO(simSuppliers)));
        return simSupplierDTO;
    }

    @Override
    public SimSupplierDTO getById(Long id) {
//        if(!simSupplierRepository.existsById(id)){
//            return STATUS
//        }
        SimSupplier simSupplier = simSupplierRepository.getById(id);
        return new SimSupplierDTO(simSupplier);
    }
}

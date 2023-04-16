package com.CRUD.demoCRUD.controllers;

import com.CRUD.demoCRUD.dto.SimMobileCarrierDTO;
import com.CRUD.demoCRUD.dto.SimSupplierDTO;
import com.CRUD.demoCRUD.entity.SimMobileCarrier;
import com.CRUD.demoCRUD.entity.SimSupplier;
import com.CRUD.demoCRUD.service.SimMobileCarrierService;
import com.CRUD.demoCRUD.service.SimSupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simmobilecarrier")
@Slf4j
public class SimMobileCarrierController {
    @Autowired
    SimMobileCarrierService simMobileCarrierService;

    @GetMapping("/")
    public List<SimMobileCarrierDTO> getAll(){return simMobileCarrierService.getAll();}

    @PostMapping("/add")
    public SimMobileCarrierDTO add(@RequestBody SimMobileCarrierDTO entity){
        return simMobileCarrierService.create(entity);
    }
    @GetMapping("/{id}")
    public SimMobileCarrierDTO getById(@PathVariable Long id){
        return simMobileCarrierService.getById(id);
    }

    @PutMapping("/{id}")
    public SimMobileCarrierDTO update(@PathVariable Long id,@RequestBody SimMobileCarrierDTO dto){
        return simMobileCarrierService.update(dto,id);
    }

}


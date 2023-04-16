package com.CRUD.demoCRUD.controllers;

import com.CRUD.demoCRUD.dto.SimMobileCarrierConfigDTO;
import com.CRUD.demoCRUD.dto.SimMobileCarrierDTO;
import com.CRUD.demoCRUD.entity.SimMobileCarrier;
import com.CRUD.demoCRUD.entity.SimMobileCarrierConfig;
import com.CRUD.demoCRUD.service.SimMobileCarrierConfigService;
import com.CRUD.demoCRUD.service.SimMobileCarrierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simmobilecarrierconfig")
@Slf4j
public class SimMobileCarrierConfigController {
    @Autowired
    SimMobileCarrierConfigService simMobileCarrierConfigService;

    @GetMapping("/")
    public List<SimMobileCarrierConfigDTO> getAll(){return simMobileCarrierConfigService.getAll();}

    @PostMapping("/add")
    public SimMobileCarrierConfigDTO add(@RequestBody SimMobileCarrierConfigDTO entity){
        return simMobileCarrierConfigService.create(entity);
    }

}


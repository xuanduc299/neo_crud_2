package com.CRUD.demoCRUD.controllers;

import com.CRUD.demoCRUD.dto.SimSupplierDTO;
import com.CRUD.demoCRUD.entity.SimSupplier;
import com.CRUD.demoCRUD.repository.SimSupplierRepository;
import com.CRUD.demoCRUD.service.SimSupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simsupplier")
@Slf4j
public class SimSupplierController {
    @Autowired
    SimSupplierService simSupplierService;

    @GetMapping("/")
    public List<SimSupplierDTO> getAll(){return simSupplierService.getAll();}

    @PostMapping("/add")
    public SimSupplierDTO add(@RequestBody SimSupplierDTO entity){
        return simSupplierService.create(entity);
    }

    @GetMapping("/{id}")
    public SimSupplierDTO getById(@PathVariable Long id){
        return simSupplierService.getById(id);
    }

    @PutMapping("/{id}")
    public SimSupplierDTO update(@PathVariable Long id,@RequestBody SimSupplierDTO dto){
        return simSupplierService.update(dto,id);
    }



}


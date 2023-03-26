package com.CRUD.demoCRUD.controllers;

import com.CRUD.demoCRUD.dto.ProvinceDTO;
import com.CRUD.demoCRUD.service.ProvinceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProvinceController {
    private final ProvinceService provinceService;

    public ProvinceController(ProvinceService provinceService) {
        this.provinceService = provinceService;
    }

    @PostMapping("/provinces")
    public ResponseEntity<?> add(@RequestBody ProvinceDTO provinceDTO){
        provinceService.create(provinceDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/provinces/list")
    public ResponseEntity<?> addAll(@RequestBody List<ProvinceDTO> provinceDTOs){
        provinceService.saveAll(provinceDTOs);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

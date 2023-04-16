package com.CRUD.demoCRUD.convert;

import com.CRUD.demoCRUD.dto.SimSupplierDTO;
import com.CRUD.demoCRUD.entity.SimSupplier;
import org.springframework.stereotype.Component;

@Component
public class SimSupplierConvert {
    public void convertDataIntoDTO(SimSupplierDTO simSupplierDTO, SimSupplier simSupplier){
//        simSupplier.setId(simSupplierDTO.getId());
        simSupplier.setName(simSupplierDTO.getName());
        simSupplier.setEdit_user(simSupplierDTO.getEdit_user());
        simSupplier.setEdit_date(simSupplierDTO.getEdit_date());
        simSupplier.setRepresentatives(simSupplierDTO.getRepresentatives());
        simSupplier.setPhone(simSupplierDTO.getPhone());
        simSupplier.setMail(simSupplierDTO.getMail());
        simSupplier.setAddress(simSupplierDTO.getAddress());

    }
}
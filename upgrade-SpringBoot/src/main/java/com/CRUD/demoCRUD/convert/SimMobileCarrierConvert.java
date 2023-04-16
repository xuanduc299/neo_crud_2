package com.CRUD.demoCRUD.convert;

import com.CRUD.demoCRUD.dto.SimMobileCarrierConfigDTO;
import com.CRUD.demoCRUD.dto.SimMobileCarrierDTO;
import com.CRUD.demoCRUD.dto.SimSupplierDTO;
import com.CRUD.demoCRUD.entity.SimMobileCarrier;
import com.CRUD.demoCRUD.entity.SimMobileCarrierConfig;
import com.CRUD.demoCRUD.entity.SimSupplier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class SimMobileCarrierConvert {
    private static SimMobileCarrierConfigConvert transformer = new SimMobileCarrierConfigConvert();

    public static SimMobileCarrierDTO toDTO(SimMobileCarrier entity){
        if (Objects.isNull(entity)){
            return null;
        }
        SimMobileCarrierDTO dto = new SimMobileCarrierDTO();
        dto.setCarrier_id(entity.getCarrier_id());
        dto.setName(entity.getName());
        dto.setMobile_carrier(transformer.toListDTO(entity.getSimMobileCarrierConfigsList()));
        return dto;
    }

    public static List<SimMobileCarrierDTO> toListDTO(List<SimMobileCarrier> entities){
        if (Objects.isNull(entities)){
            return null;
        }
        List<SimMobileCarrierDTO> dtoList = new ArrayList<>();
        for(SimMobileCarrier entity : entities){
            SimMobileCarrierDTO dto = toDTO(entity);
            dtoList.add(dto);
        }
        return dtoList;
    }

    public void convertDataIntoDTO(SimMobileCarrierDTO mobileCarrierDTO, SimMobileCarrier simMobileCarrier){
        simMobileCarrier.setCarrier_id(mobileCarrierDTO.getCarrier_id());
        simMobileCarrier.setName(mobileCarrierDTO.getName());
    }
}

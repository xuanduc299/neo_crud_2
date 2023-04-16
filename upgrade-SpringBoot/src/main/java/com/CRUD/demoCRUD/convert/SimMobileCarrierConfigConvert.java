package com.CRUD.demoCRUD.convert;

import com.CRUD.demoCRUD.dto.SimMobileCarrierConfigDTO;
import com.CRUD.demoCRUD.dto.SimMobileCarrierDTO;
import com.CRUD.demoCRUD.entity.SimMobileCarrier;
import com.CRUD.demoCRUD.entity.SimMobileCarrierConfig;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class SimMobileCarrierConfigConvert {
    public static SimMobileCarrierConfigDTO toDTO(SimMobileCarrierConfig entity){
        if (Objects.isNull(entity)){
            return null;
        }
        SimMobileCarrierConfigDTO dto = new SimMobileCarrierConfigDTO();
        dto.setCarrier_config_id(entity.getCarrier_config_id());
        dto.setCarrier_id(entity.getCarrier_id());
        dto.setName(entity.getName());
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        return dto;
    }

    public static List<SimMobileCarrierConfigDTO> toListDTO(List<SimMobileCarrierConfig> entities){
        if (Objects.isNull(entities)){
            return null;
        }
        List<SimMobileCarrierConfigDTO> dtoList = new ArrayList<>();
        for(SimMobileCarrierConfig entity : entities){
            SimMobileCarrierConfigDTO dto = toDTO(entity);
            dtoList.add(dto);
        }
        return dtoList;
    }

    public void convertDataIntoDTO(SimMobileCarrierConfigDTO simMobileCarrierConfigDTO, SimMobileCarrierConfig simMobileCarrierConfig){
        simMobileCarrierConfig.setCarrier_config_id(simMobileCarrierConfigDTO.getCarrier_config_id());
        simMobileCarrierConfig.setCarrier_id(simMobileCarrierConfigDTO.getCarrier_id());
        simMobileCarrierConfig.setName(simMobileCarrierConfigDTO.getName());
        simMobileCarrierConfig.setUsername(simMobileCarrierConfigDTO.getUsername());
        simMobileCarrierConfig.setPassword(simMobileCarrierConfigDTO.getPassword());

    }
}

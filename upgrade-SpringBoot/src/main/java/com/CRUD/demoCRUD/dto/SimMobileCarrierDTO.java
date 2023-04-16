package com.CRUD.demoCRUD.dto;

import com.CRUD.demoCRUD.entity.SimMobileCarrier;
import com.CRUD.demoCRUD.entity.SimSupplier;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimMobileCarrierDTO {
    private Long carrier_id;

    private String name;

    private List<SimMobileCarrierConfigDTO> mobile_carrier;

    public SimMobileCarrierDTO() {
    }

    public SimMobileCarrierDTO(SimMobileCarrier entity) {
        if (entity != null) {
            this.setCarrier_id(entity.getCarrier_id());
            this.setName(entity.getName());
        }
    }
}
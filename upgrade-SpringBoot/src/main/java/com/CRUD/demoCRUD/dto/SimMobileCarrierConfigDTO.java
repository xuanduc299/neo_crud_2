package com.CRUD.demoCRUD.dto;

import com.CRUD.demoCRUD.entity.SimMobileCarrier;
import com.CRUD.demoCRUD.entity.SimMobileCarrierConfig;
import com.CRUD.demoCRUD.entity.SimSupplier;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import java.util.List;

@Data
@SuperBuilder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimMobileCarrierConfigDTO {
    private Long carrier_config_id;

    private Long carrier_id;

    private String name;

    private String username;

    private String password;

    public SimMobileCarrierConfigDTO() {
    }

    public SimMobileCarrierConfigDTO(SimMobileCarrierConfig entity) {
        if (entity != null) {
            this.setCarrier_config_id(entity.getCarrier_config_id());
            this.setCarrier_id(entity.getCarrier_id());
            this.setName(entity.getName());
            this.setUsername(entity.getUsername());
            this.setPassword(entity.getPassword());
        }
    }
}
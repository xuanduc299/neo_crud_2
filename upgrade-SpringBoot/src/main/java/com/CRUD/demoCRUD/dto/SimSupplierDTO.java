package com.CRUD.demoCRUD.dto;

import com.CRUD.demoCRUD.entity.SimSupplier;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@SuperBuilder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SimSupplierDTO {
    private Long id;

    private String name;

    private Integer edit_user;

    private LocalDate edit_date;

    private String representatives;

    private String phone;

    private String mail;

    private String address;

    public SimSupplierDTO() {
    }

    public SimSupplierDTO(SimSupplier entity) {
        if (entity != null) {
            this.setId(entity.getId());
            this.setName(entity.getName());
            this.setEdit_user(entity.getEdit_user());
            this.setEdit_date(entity.getEdit_date());
            this.setRepresentatives(entity.getRepresentatives());
            this.setPhone(entity.getPhone());
            this.setMail(entity.getMail());
            this.setAddress(entity.getAddress());
        }
    }
}
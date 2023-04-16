package com.CRUD.demoCRUD.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "SIM_SUPPLIER")
@FieldNameConstants
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimSupplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EDIT_USER")
    private Integer edit_user;

    @Column(name = "EDIT_DATE")
    private LocalDate edit_date;

    @Column(name = "REPRESENTATIVES")
    private String representatives;

    @Column(name = "SDT")
    private String phone;

    @Column(name = "MAIL")
    private String mail;

    @Column(name = "ADDRESS")
    private String address;
}
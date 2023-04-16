package com.CRUD.demoCRUD.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;

@Entity(name = "SIM_MOBILE_CARRIER_CONFIG")
@Table(name = "SIM_MOBILE_CARRIER_CONFIG")
@FieldNameConstants
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimMobileCarrierConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "CARRIER_CONFIG_ID")
    private Long carrier_config_id;

    @Column(name = "CARRIER_ID")
    private Long carrier_id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "PASSWORD")
    private String password;
}

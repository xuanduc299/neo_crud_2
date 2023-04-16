package com.CRUD.demoCRUD.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.List;

@Entity(name = "SIM_MOBILE_CARRIER")
@Table(name = "SIM_MOBILE_CARRIER")
@FieldNameConstants
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SimMobileCarrier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "CARRIER_ID")
    private Long carrier_id;

    @Column(name = "NAME")
    private String name;

    @OneToMany
    @JoinColumn(name = "carrier_id",referencedColumnName = "carrier_id")
    private List<SimMobileCarrierConfig> simMobileCarrierConfigsList;

}

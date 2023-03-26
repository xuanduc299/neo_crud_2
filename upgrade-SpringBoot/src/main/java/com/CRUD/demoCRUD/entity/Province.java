package com.CRUD.demoCRUD.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "province")
public class Province {
    @Id
    @Column
    private int code;
    @Column
    private String name;
    @Column
    private  String division_type;
    @Column
    private String codename;
    @Column
    private int phone_code;

    public Province() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDivision_type() {
        return division_type;
    }

    public void setDivision_type(String division_type) {
        this.division_type = division_type;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public int getPhone_code() {
        return phone_code;
    }

    public void setPhone_code(int phone_code) {
        this.phone_code = phone_code;
    }
}

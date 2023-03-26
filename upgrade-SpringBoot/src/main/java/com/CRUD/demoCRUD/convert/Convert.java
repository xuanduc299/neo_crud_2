package com.CRUD.demoCRUD.convert;

import com.CRUD.demoCRUD.dto.*;
import com.CRUD.demoCRUD.entity.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class Convert {
    public void convertDataIntoDTO(ProductDTO productDTO, Product product){
        product.setMaSp(productDTO.getMaSp());
        product.setName(productDTO.getName());
        product.setDate(productDTO.getDate());
        product.setProduct_width(productDTO.getProduct_width());
        product.setProduct_height(productDTO.getProduct_height());
        product.setColor(productDTO.getColor());
        product.setQuantity(productDTO.getQuantity());
        product.setBrand(productDTO.getBrand());
        product.setMaterial(productDTO.getMaterial());
        product.setSectors(productDTO.getSectors());
    }

    public void convertDataIntoDTO(CustomerDTO customerDTO, Customer customer,Product product){
        customer.setMakh(customerDTO.getMakh());
        customer.setName(customerDTO.getName());
        customer.setAge(customerDTO.getAge());
        customer.setAddress(customerDTO.getAddress());
        customer.setDate(customerDTO.getDate());
        customer.setQuantity(customerDTO.getQuantity());
        customer.setSectors(customerDTO.getSectors());
        customer.setProduct(product);
    }

    public static Province convertDataIntoDTO (ProvinceDTO provinceDTO){
        Province province = new Province();
        province.setName(provinceDTO.getName());
        province.setCode(provinceDTO.getCode());
        province.setDivision_type(provinceDTO.getDivision_type());
        province.setCodename(provinceDTO.getCodename());
        province.setPhone_code(provinceDTO.getPhone_code());
        return province;
    }

    public District convertDataIntoDTO(DistrictDTO districtDTO){
        District district = new District();
        district.setName(districtDTO.getName());
        district.setCode(districtDTO.getCode());
        district.setDivision_type(districtDTO.getDivision_type());
        district.setCodename(districtDTO.getCodename());
        district.setProvince_code(districtDTO.getProvince_code());
        return district;
    }

    public Ward convertDataIntoDTO(WardDTO wardDTO){
        Ward ward = new Ward();
        ward.setName(wardDTO.getName());
        ward.setCode(wardDTO.getCode());
        ward.setDivision_type(wardDTO.getDivision_type());
        ward.setCodename(wardDTO.getCodename());
        ward.setDistrict_code(wardDTO.getDistrict_code());
        return ward;
    }

    public static List<Province> listAllProvince(List<ProvinceDTO> provinceDTO){
        if(Objects.isNull(provinceDTO)){
            return null;
        }
        List<Province> entity = new ArrayList<>();
        for (ProvinceDTO provinceDTOs:provinceDTO) {
            Province province = new Province();
            province.setName(provinceDTOs.getName());
            province.setCode(provinceDTOs.getCode());
            province.setDivision_type(provinceDTOs.getDivision_type());
            province.setCodename(provinceDTOs.getCodename());
            province.setPhone_code(provinceDTOs.getPhone_code());
            entity.add(province);
        }
        return entity;
    }
    public static List<District> listAllDistrict(List<DistrictDTO> districtDTO){
        if(Objects.isNull(districtDTO)){
            return null;
        }
        List<District> entity = new ArrayList<>();
        for (DistrictDTO districtDTOs:districtDTO) {
            District district = new District();
            district.setCode(districtDTOs.getCode());
            district.setName(districtDTOs.getName());
            district.setDivision_type(districtDTOs.getDivision_type());
            district.setCodename(districtDTOs.getCodename());
            district.setProvince_code(districtDTOs.getProvince_code());
            entity.add(district);
        }
        return entity;
    }


    public static List<Ward> listAllWard(List<WardDTO> wardDTO){
        if(Objects.isNull(wardDTO)){
            return null;
        }
        List<Ward> entity = new ArrayList<>();
        for (WardDTO wardDTOs:wardDTO) {
            Ward ward = new Ward();
            ward.setName(wardDTOs.getName());
            ward.setCode(wardDTOs.getCode());
            ward.setDivision_type(wardDTOs.getDivision_type());
            ward.setCodename(wardDTOs.getCodename());
            ward.setDistrict_code(wardDTOs.getDistrict_code());
            entity.add(ward);
        }
        return entity;
    }


}

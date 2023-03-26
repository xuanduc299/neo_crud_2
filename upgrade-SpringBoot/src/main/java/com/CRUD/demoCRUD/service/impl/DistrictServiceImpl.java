package com.CRUD.demoCRUD.service.impl;

import com.CRUD.demoCRUD.convert.Convert;
import com.CRUD.demoCRUD.dto.DistrictDTO;
import com.CRUD.demoCRUD.dto.ProvinceDTO;
import com.CRUD.demoCRUD.repository.DistrictRepository;
import com.CRUD.demoCRUD.service.DistrictService;
import com.CRUD.demoCRUD.service.ProvinceService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;

    private final Convert convert;

    public DistrictServiceImpl(DistrictRepository districtRepository, Convert convert) {
        this.districtRepository = districtRepository;
        this.convert = convert;
    }


    @Override
    public void create(DistrictDTO dto) {
        districtRepository.save(convert.convertDataIntoDTO(dto));
    }

    @Override
    public void saveAll(List<DistrictDTO> dto) {
        districtRepository.saveAll(convert.listAllDistrict(dto));
    }
}

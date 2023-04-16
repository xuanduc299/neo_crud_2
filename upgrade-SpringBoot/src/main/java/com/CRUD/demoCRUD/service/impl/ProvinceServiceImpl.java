package com.CRUD.demoCRUD.service.impl;

import com.CRUD.demoCRUD.convert.Convert;
import com.CRUD.demoCRUD.dto.ProvinceDTO;
import com.CRUD.demoCRUD.repository.ProvinceRepository;
import com.CRUD.demoCRUD.service.ProvinceService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProvinceServiceImpl implements ProvinceService {

    private final ProvinceRepository provinceRepository;

    private final Convert convert;

    public ProvinceServiceImpl(ProvinceRepository provinceRepository, Convert convert) {
        this.provinceRepository = provinceRepository;
        this.convert = convert;
    }


    @Override
    public void create(ProvinceDTO dto) {
        provinceRepository.save(convert.convertDataIntoDTO(dto));
    }

    @Override
    public void saveAll(List<ProvinceDTO> dto) {
        provinceRepository.saveAll(convert.listAllProvince(dto));
    }
}

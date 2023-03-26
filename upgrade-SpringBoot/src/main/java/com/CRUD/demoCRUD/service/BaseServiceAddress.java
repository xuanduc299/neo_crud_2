package com.CRUD.demoCRUD.service;

import com.CRUD.demoCRUD.dto.Response;

import java.util.List;

public interface BaseServiceAddress<T> {
    public void create(T dto);
    public void saveAll(List<T> dto);
}

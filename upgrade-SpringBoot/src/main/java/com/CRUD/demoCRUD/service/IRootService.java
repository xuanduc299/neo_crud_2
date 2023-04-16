package com.CRUD.demoCRUD.service;

public interface IRootService <T>{
    T create (T entity);

    T retrieve(Long id);

    T update(T entity,Long id);

    void delete(Long id);
}

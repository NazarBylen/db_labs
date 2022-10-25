package com.rest.domain.Service;

import java.util.List;

public interface GeneralServiceInterface<T, ID> {
    List<T> findAll();

    T findById(ID id);

//    T create(T entity);
//
//    void update(ID id, T entity);
//
//    void delete(ID id);
}

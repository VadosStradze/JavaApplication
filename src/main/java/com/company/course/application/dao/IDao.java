package com.company.course.application.dao;

import java.util.List;

public interface IDao<T> {
    T add(T type);

    void delete(Long id);

    T findById(Long id) ;

    T updateById(Long id, T type) ;

    List<T> showAll() ;
}

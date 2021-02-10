package com.company.course.application.service;

import com.company.course.application.entity.Client;

import java.util.List;

public interface IService<T> {

    List<T> showAll();

    T add(T type);

    void deleteById(Long id);

    T update(Long id, T type);

    T findById(Long id);

    List<T> findByCoachId(Long coachId);
}

package com.company.course.application.dao;


import com.company.course.application.entity.Coach;

import java.io.IOException;
import java.util.List;

public interface CoachDao {
    Coach add(Coach coach);

    void deleteById(Long id);
    Coach findById(Long id) throws IOException;
    Coach getById(Long id);
    List<Coach> showAll();
    Coach update(Long id,Coach coach) throws IOException;
}



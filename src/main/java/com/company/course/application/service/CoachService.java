package com.company.course.application.service;

import com.company.course.application.dao.CoachDao;
import com.company.course.application.entity.Client;
import com.company.course.application.entity.Coach;

import java.io.IOException;
import java.util.List;

public interface CoachService {
    Coach add(Coach coach);
    List<Coach> showAll();
    Coach findById(Long id)  throws IOException;
    void deleteById(Long id);
    Coach update(Long id,Coach coach);

}

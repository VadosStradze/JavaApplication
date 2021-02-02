package com.company.course.application.service.impl;

import com.company.course.application.dao.ClientDao;
import com.company.course.application.dao.CoachDao;
import com.company.course.application.entity.Coach;
import com.company.course.application.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public class CoachServiceImpl implements CoachService {

    private CoachDao coachDao;


    public CoachServiceImpl(CoachDao coachDao) {
        this.coachDao = coachDao;
    }


    @Override
    public Coach add(Coach coach) {
        coachDao.add(coach);
        return coach;
    }

    @Override
    public List<Coach> showAll() {
        return coachDao.showAll();
    }

    @Override
    public Coach findById(Long id) throws IOException {
        return coachDao.findById(id);
    }

    @Override
    public Coach getById(Long id) {

        return coachDao.getById(id);

    }

    @Override
    public void deleteById(Long id) {
        coachDao.deleteById(id);

    }

    @Override
    public Coach update(Long id, Coach coach) {
        try {
            Coach newCoach = coachDao.update(id, coach);
            return newCoach;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}

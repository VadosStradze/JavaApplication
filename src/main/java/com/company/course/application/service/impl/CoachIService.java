package com.company.course.application.service.impl;

import com.company.course.application.dao.CoachDao;
import com.company.course.application.dao.IDao;
import com.company.course.application.entity.Coach;
import com.company.course.application.service.IService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


@Service
public class CoachIService implements IService<Coach> {

    private IDao<Coach> coachDao;


    public CoachIService(IDao<Coach> coachDao) {
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
    public Coach findById(Long id)  {
        return coachDao.findById(id);
    }




    @Override
    public void deleteById(Long id) {
        coachDao.delete(id);

    }

    @Override
    public Coach update(Long id, Coach coach) {
        try {
            Coach newCoach = coachDao.updateById(id, coach);
            return newCoach;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}

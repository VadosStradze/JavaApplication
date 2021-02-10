package com.company.course.application.service.impl;

import com.company.course.application.dao.IDao;
import com.company.course.application.entity.Gym;
import com.company.course.application.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GymService implements IService<Gym> {
    private final IDao<Gym> gymDao;

    @Autowired
    public GymService(@Qualifier("gymDaoSpringJDBC") IDao<Gym> gymDao) {
        this.gymDao = gymDao;
    }

    @Override
    public Gym add(Gym type) {
        gymDao.add(type);
        return type;
    }

    @Override
    public void deleteById(Long id) {
        gymDao.delete(id);
    }

    @Override
    public Gym findById(Long id) {
        return gymDao.findById(id);
    }

    @Override
    public List<Gym> findByCoachId(Long coachId) {
        return null;
    }

    @Override
    public Gym update(Long id, Gym type) {
        Gym newGym = gymDao.updateById(id, type);
        return newGym;
    }

    @Override
    public List<Gym> showAll() {
        return gymDao.showAll();
    }
}

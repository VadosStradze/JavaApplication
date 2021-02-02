package com.company.course.application.dao.impl;

import com.company.course.application.dao.CoachDao;
import com.company.course.application.entity.Coach;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Deprecated
public class CoachDaoImpl implements CoachDao {
    private List<Coach> coachList = new ArrayList<>();
    private List<Coach> toRemove = new ArrayList<>();//ДОБАВИЛ КОЛЛЕКЦИЮ ДЛЯ ОБХОДА КАНКАРЕНН.ЭКСЕПТИОН


    @Override
    //Удаляем тренера по Id
    public void deleteById(Long id) {
        Iterator<Coach> coachIterator = coachList.iterator();
        while (coachIterator.hasNext()) {
            Coach nextCoach = coachIterator.next();
            if (nextCoach.getId().equals(id)) {
                coachIterator.remove();
                System.out.println("Coach under ID " + id + " was deleted!");
            }
        }

        /*for (Coach finder : coachList) {
            if (finder.getId().equals(id)) {
                System.out.println("Remove coach under id: "+finder.getId());
                toRemove.add(finder);

            }
        }
       coachList.remove(toRemove);*/
        //

    }

    @Override
    public Coach findById(Long id) throws IOException {
        return null;
    }

    @Override
    //находим тренера по Id
    public Coach getById(Long id) {
        for (Coach finder : coachList) {
            if (finder.getId().equals(id)) {
                return finder;
            }
        }
        return null;
    }

    @Override
    public List<Coach> showAll() {
        if (coachList.isEmpty()) {
            System.out.println("Coach database is empty: ");
        }
        for (Coach finder : coachList) {
            System.out.println(finder.toString());

        }
        return coachList;
    }



    @Override
    public Coach update(Long id, Coach coach) throws IOException {
        return null;
    }


    @Override
    //Добавляем тренера с уникальным Id
    public Coach add(Coach coach) {
        //метод
        Long id = prepareUniqueId();
        coach.setId(id);
        coachList.add(coach);
        return coach;
    }

    //Генерируем уникальный Id  *************************************
    private Long prepareUniqueId() {
        long max = -1;
        for (Coach finder : coachList) {
            if (finder.getId() > max) {
                max = finder.getId();
            }
        }
        max++;

        return max;
    }


}

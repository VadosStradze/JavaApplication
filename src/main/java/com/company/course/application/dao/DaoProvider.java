package com.company.course.application.dao;

//import com.company.course.application.dao.impl.ClientDaoImpl;
import com.company.course.application.dao.impl.CoachDaoImpl;

public final class DaoProvider {
    private static final DaoProvider instance = new DaoProvider();
    private final CoachDao listCoachImpl = new CoachDaoImpl();
    //private final ClientDao listClientImpl = new ClientDaoImpl();

    public DaoProvider() {
    }

    public static DaoProvider getInstance() {
        return instance;
    }

    public CoachDao getCoachDao() {
        return listCoachImpl;
    }

   /*// public ClientDao getClientDao() {
        return listClientImpl;
    }*/
}

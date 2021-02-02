package com.company.course.application.configuration;

import com.company.course.application.dao.ClientDao;
import com.company.course.application.dao.impl.DBClientDaoImpl;
import com.company.course.application.dao.impl.DBCoachDaoImpl;
import com.company.course.application.service.ClientService;
import com.company.course.application.service.CoachService;
import com.company.course.application.service.impl.ClientServiceImpl;
import com.company.course.application.service.impl.CoachServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.company.course.application")
public class Config {

    @Bean
    public ClientService clientService(){
        return new ClientServiceImpl(new DBClientDaoImpl());
    }

    @Bean
    public CoachService coachService(){
        return new CoachServiceImpl(new DBCoachDaoImpl());
    }
}

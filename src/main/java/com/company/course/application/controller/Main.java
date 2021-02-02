package com.company.course.application.controller;


import com.company.course.application.configuration.Config;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

    public static void main(String[] args) {
        /*ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"context.xml"});
        Console console = context.getBean("console", Console.class);*/
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Console console = context.getBean(Console.class);

        // Console console1 = new Console(new CoachServiceImpl(new DBCoachDaoImpl()),new ClientServiceImpl(new DBClientDaoImpl()));

        console.menu();
    }
}

package com.company.course.application.configuration;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.company.course.application")
public class Config {
    @Bean
    public DataSource mysqlDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test_base");
        dataSource.setUsername("root");
        dataSource.setPassword("6054704ADRt");
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(mysqlDataSource());
    }

}

package com.company.course.application.dao.impl;

import com.company.course.application.dao.CoachDao;

import com.company.course.application.dao.IDao;
import com.company.course.application.entity.Coach;
import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Repository
public class DBCoachDaoImpl implements IDao<Coach> {

    @Override
    public Coach add(Coach coach) {
        try {

            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO coach (first_name,last_name,gender,experience) VALUES (?,?,?,?)");
            statement.setString(1, coach.getFirstName());
            statement.setString(2, coach.getLastName());
            statement.setString(3, coach.getSex());
            statement.setInt(4,coach.getExperience());
            statement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        return coach;
    }

    @Override
    public void delete(Long id) {
        try {
            PreparedStatement statement = createStatement("DELETE FROM coach WHERE coach_id = (?) ");
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Coach findById(Long id)  {
        Coach coachById = new Coach();
        try {
            PreparedStatement statement = createStatement("Select coach_id,first_name,last_name,gender,experience FROM coach WHERE coach_id = (?)");
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Long coachId = result.getLong(1);
                String name = result.getString(2);
                String lastName = result.getString(3);
                String gender = result.getString(4);
                int experience = result.getInt(5);


                coachById.setFirstName(name);
                coachById.setLastName(lastName);
                coachById.setSex(gender);
                coachById.setExperience(experience);
                coachById.setId(coachId);



            }
            return coachById;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return coachById;
    }





    @Override
    public Coach updateById(Long id, Coach coach)  {
        try {
            PreparedStatement statement = createStatement("UPDATE coach Set first_name = (?),last_name = (?), gender = (?), experience = (?) WHERE coach_id = (?)");
            statement.setLong(5, id);
            statement.setString(1, coach.getFirstName());
            statement.setString(2, coach.getLastName());
            statement.setString(3, coach.getSex());
            statement.setInt(4,coach.getExperience());
            statement.execute();

            System.out.println(coach.toString());
            return coach;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return coach;

    }

    @Override
    public List<Coach> showAll() {
        List<Coach> coachList = new ArrayList<>();

        try {

            ResultSet result = createStatement("SELECT coach_id,first_name,last_name,gender,experience FROM coach").executeQuery();
            /*Statement statement = getConnection().prepareStatement("SELECT id,first_name,last_name,gender FROM client");
            ResultSet result = statement.executeQuery("SELECT id,first_name,last_name,gender FROM client");*/
            while (result.next()) {
                String firstName = result.getString(2);
                String lastName = result.getString(3);
                String gender = result.getString(4);
                int experience = result.getInt(5);
                Long id = result.getLong(1);
                Coach coach = new Coach(firstName,lastName,gender,experience);
                coach.setId(id);
                coachList.add(coach);
            }
            return coachList;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return coachList;

    }




    public static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        try {
            FileInputStream inputFromResource = new FileInputStream("src/main/resources/databasesql.properties");
            properties.load(inputFromResource);
            String userName = properties.getProperty("db.login");
            String password = properties.getProperty("db.password");
            String url = properties.getProperty("db.url");

            return DriverManager.getConnection(url, userName, password);
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static PreparedStatement createStatement(String sql) throws SQLException {
        return getConnection().prepareStatement(sql);
    }


}
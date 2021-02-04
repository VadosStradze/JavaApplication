package com.company.course.application.dao.impl;

import com.company.course.application.dao.ClientDao;
import com.company.course.application.dao.IDao;
import com.company.course.application.entity.Client;
import org.springframework.stereotype.Repository;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Repository
public class DBClientDaoImpl implements IDao<Client> {

    @Override
    public Client add(Client client) {
        try {

            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO client (first_name,last_name,gender,coach_id) VALUES (?,?,?,?)");
            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getLastName());
            statement.setString(3, client.getSex());
            if (client.getCoachId() != null) {
                statement.setLong(4, client.getCoachId());
            } else {
                statement.setString(4, null);
            }
            statement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();
        return client;
    }

    @Override
    public void delete(Long id) {
        try {
            PreparedStatement statement = createStatement("DELETE FROM client WHERE id = (?) ");
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Client findById(Long id) {
        Client clientById = new Client();
        try {
            PreparedStatement statement = createStatement("Select id,first_name,last_name,gender,coach_id FROM client WHERE id = (?)");
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Long clientId = result.getLong(1);
                String name = result.getString(2);
                String lastName = result.getString(3);
                String gender = result.getString(4);


                clientById.setFirstName(name);
                clientById.setLastName(lastName);
                clientById.setSex(gender);
                clientById.setId(clientId);


                // TODO: 25.01.2021 Все выводы в консоли!  
            }
            return clientById;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return clientById;
    }


    @Override
    // TODO: 26.01.2021 Решить проблему с ID Клиента в программе!  
    public Client updateById(Long id, Client client) {
        try {
            PreparedStatement statement = createStatement("UPDATE client Set first_name = (?),last_name = (?), gender = (?) WHERE id = (?)");
            statement.setLong(4, id);
            statement.setString(1, client.getFirstName());
            statement.setString(2, client.getLastName());
            statement.setString(3, client.getSex());
            statement.execute();
            System.out.println(client.toString());
            return client;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return client;

    }

    @Override
    public List<Client> showAll() {
        List<Client> clientList = new ArrayList<>();

        try {

            Statement statement = getConnection().prepareStatement("SELECT id,first_name,last_name,gender FROM client");
            ResultSet result = statement.executeQuery("SELECT id,first_name,last_name,gender,coach_id FROM client");
            while (result.next()) {
                String firstName = result.getString(2);
                String lastName = result.getString(3);
                String gender = result.getString(4);
                long coachId = result.getLong(5);
                Long id = result.getLong(1);
                Client client = new Client(firstName, lastName, gender, coachId);
                client.setId(id);
                clientList.add(client);
            }
            return clientList;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return clientList;

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
        } catch (FileNotFoundException e) {
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

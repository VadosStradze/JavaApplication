package com.company.course.application.util;

import com.company.course.application.entity.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRowMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet resultSet, int i) throws SQLException {
        Client client = new Client();
        client.setFirstName(resultSet.getString("first_name"));
        client.setLastName(resultSet.getString("last_name"));
        client.setId(resultSet.getLong("id"));
        client.setCoachId(resultSet.getLong("coach_id"));
        client.setSex(resultSet.getString("gender"));
        return client;
    }
}

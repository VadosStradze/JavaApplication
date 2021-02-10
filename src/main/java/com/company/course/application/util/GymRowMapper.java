package com.company.course.application.util;

import com.company.course.application.entity.Address;
import com.company.course.application.entity.Gym;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GymRowMapper implements RowMapper<Gym> {
    @Override
    public Gym mapRow(ResultSet resultSet, int i) throws SQLException {
        Gym gym = new Gym();
        Address address = new Address();
        gym.setGymId(resultSet.getLong("gym_id"));
        gym.setGymName(resultSet.getString("gym_name"));
        gym.setAddressId(resultSet.getLong("address_id"));
        return gym;
    }
}

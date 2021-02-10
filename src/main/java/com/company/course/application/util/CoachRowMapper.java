package com.company.course.application.util;

import com.company.course.application.entity.Coach;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoachRowMapper implements RowMapper<Coach> {

    @Override
    public Coach mapRow(ResultSet resultSet, int i) throws SQLException {
        Coach coach = new Coach();
        coach.setId(resultSet.getLong("coach_id"));
        coach.setExperience(resultSet.getInt("experience"));
        coach.setFirstName(resultSet.getString("first_name"));
        coach.setLastName(resultSet.getString("last_name"));
        coach.setSex(resultSet.getString("gender"));
        coach.setGymId(resultSet.getLong("gym_id"));
        return coach;
    }
}

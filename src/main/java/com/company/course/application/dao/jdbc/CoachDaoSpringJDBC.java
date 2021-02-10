package com.company.course.application.dao.jdbc;

import com.company.course.application.dao.IDao;
import com.company.course.application.entity.Coach;
import com.company.course.application.util.CoachRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("coachDaoSpringJdbc")
public class CoachDaoSpringJDBC implements IDao<Coach> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CoachDaoSpringJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Coach add(Coach type) {
        String SQL = "INSERT INTO coach(coach_id,first_name,last_name,gender,gym_id,experience) VALUES (?,?,?,?,?,?)";
        jdbcTemplate.update(SQL, type.getId(), type.getFirstName(), type.getLastName(), type.getSex(),type.getGymId(),type.getExperience());
        return type;
    }

    @Override
    public void delete(Long id) {
        String SQL = "DELETE FROM coach WHERE coach_id =?";
    jdbcTemplate.update(SQL, id);
    }

    @Override
    public Coach findById(Long id) {
        String SQL = "SELECT coach_id,first_name,last_name,gender,experience,gym_id FROM coach WHERE coach_id=" + id;
        Coach coach = jdbcTemplate.queryForObject(SQL, new CoachRowMapper());
        return coach;
    }

    @Override
    public Coach updateById(Long id, Coach type) {
        String SQL = "UPDATE coach SET first_name = (?), last_name = (?), gender = (?), experience=(?), gym_id=(?) WHERE coach_id =(?)";
        jdbcTemplate.update(SQL, type.getFirstName(), type.getLastName(), type.getSex(),type.getExperience(),type.getGymId(), id);
        return type;
    }

    @Override
    public List<Coach> showAll() {
        String SQL = "SELECT * FROM coach";
        List<Coach> coachList = jdbcTemplate.query(SQL, new CoachRowMapper());
        return coachList;
    }

    @Override
    public List<Coach> findByCoachId(Long coachId) {
        return null;
    }
// TODO: 10.02.2021 козда коуч  меняет зал сделать так, чтобы у клиентазатирался коуч

}

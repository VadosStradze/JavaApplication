package com.company.course.application.dao.jdbc;

import com.company.course.application.dao.IDao;
import com.company.course.application.entity.Gym;
import com.company.course.application.util.GymRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("gymDaoSpringJDBC")
public class GymDaoSpringJDBC implements IDao<Gym> {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public GymDaoSpringJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Gym add(Gym type) {
        String SQL = "INSERT INTO gym(gym_name,address_id) VALUES (?,?) ";
        jdbcTemplate.update(SQL, type.getGymName(),type.getAddressId());
        return type;
    }

    @Override
    public void delete(Long id) {
        String SQL = "DELETE FROM gym WHERE gym_id =?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public Gym findById(Long id) {
        String SQL = "SELECT gym_id,gym_name,gym_address FROM gym WHERE gym_id=" + id;
        Gym gym = jdbcTemplate.queryForObject(SQL, new GymRowMapper());
        return gym;
    }

    @Override
    public Gym updateById(Long id, Gym type) {
        String SQL = "UPDATE gym SET gym_name =(?), address_id = (?) WHERE gym_id = (?)";
        jdbcTemplate.update(SQL, type.getGymName(), type.getAddressId(), type.getGymId());
        return type;

    }

    @Override
    public List<Gym> showAll() {
        String SQL = "SELECT * FROM gym";
        List<Gym> gymList = jdbcTemplate.query(SQL, new GymRowMapper());
        return gymList;
    }

    @Override
    public List<Gym> findByCoachId(Long coachId) {
        return null;
    }
}

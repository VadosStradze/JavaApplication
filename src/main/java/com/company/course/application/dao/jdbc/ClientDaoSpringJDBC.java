package com.company.course.application.dao.jdbc;

import com.company.course.application.dao.IDao;
import com.company.course.application.entity.Client;
import com.company.course.application.util.ClientRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("clientDaoSpringJdbc")
public class ClientDaoSpringJDBC implements IDao<Client> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClientDaoSpringJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Client add(Client type) {
        String SQL = "INSERT INTO client(id,first_name,last_name,gender,coach_id) VALUES (?,?,?,?,?)";
        jdbcTemplate.update(SQL, type.getId(), type.getFirstName(), type.getLastName(), type.getSex(), type.getCoachId());
        return type;
    }

    @Override
    public void delete(Long id) {
        String SQL = "DELETE FROM client WHERE id =?";
        jdbcTemplate.update(SQL, id);

    }

    @Override
    public Client findById(Long id) {
        String SQL = "SELECT id,first_name,last_name,gender,coach_id FROM client WHERE id =" + id;
        Client client = jdbcTemplate.queryForObject(SQL, new ClientRowMapper());
        return client;
    }

    @Override
    public Client updateById(Long id, Client type) {
        String SQL = "UPDATE client SET first_name = (?), last_name = (?), gender = (?),coach_id = (?) WHERE id =(?)";
        jdbcTemplate.update(SQL, type.getFirstName(), type.getLastName(), type.getSex(),type.getCoachId(), id);
        return type;
    }

    public  List<Client> findByCoachId(Long coachId){
        String SQL = "SELECT id,first_name,last_name,gender,coach_id from client WHERE coach_id =(?)";
        List<Client> clientList = new ArrayList<>();
        clientList = jdbcTemplate.query(SQL,new ClientRowMapper(),coachId);
        return clientList;
    }

    @Override
    public List<Client> showAll() {
        String SQL = "SELECT * FROM client";
        List<Client> clientList = jdbcTemplate.query(SQL, new ClientRowMapper());
        return clientList;
    }
}

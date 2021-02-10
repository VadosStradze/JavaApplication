package com.company.course.application.dao.jdbc;

import com.company.course.application.dao.IDao;
import com.company.course.application.entity.Address;
import com.company.course.application.util.AddressRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("addressDaoSpringJDBC")
public class AddressDaoSpringJDBC implements IDao<Address> {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AddressDaoSpringJDBC(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Address add(Address type) {
        String SQL = "INSERT INTO address(city,country,address) VALUES (?,?,?)";
        jdbcTemplate.update(SQL, type.getCity(), type.getCountry(),type.getAddress());
        return type;
    }

    @Override
    public void delete(Long id) {
        String SQL = "DELETE FROM address WHERE id=?";
        jdbcTemplate.update(SQL, id);
    }

    @Override
    public Address findById(Long id) {
        String SQL = "SELECT address_id,city,country FROM address WHERE address_id=" + id;//todo
        Address address = jdbcTemplate.queryForObject(SQL, new AddressRowMapper());
        return address;
    }

    @Override
    public Address updateById(Long id, Address type) {
        String SQL = "UPDATE address SET city = (?),country=(?) WHERE id = (?)";
        jdbcTemplate.update(SQL, type.getCity(), type.getCountry(), id);
        return type;
    }

    @Override
    public List<Address> showAll() {
        String SQL = "SELECT address_id,city,country FROM address";
        List<Address> addressList = jdbcTemplate.query(SQL, new AddressRowMapper());
        return addressList;
    }

    @Override
    public List<Address> findByCoachId(Long coachId) {
        return null;
    }
}

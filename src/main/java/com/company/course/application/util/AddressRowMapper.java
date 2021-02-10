package com.company.course.application.util;

import com.company.course.application.entity.Address;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressRowMapper implements RowMapper<Address> {
    @Override
    public Address mapRow(ResultSet resultSet, int i) throws SQLException {
        Address address = new Address();
        address.setId(resultSet.getLong("address_id"));
        address.setCity(resultSet.getString("city"));
        address.setCountry(resultSet.getString("country"));
        return address;
    }
}

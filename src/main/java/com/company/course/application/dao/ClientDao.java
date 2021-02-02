package com.company.course.application.dao;

import com.company.course.application.entity.Client;
import com.company.course.application.entity.Coach;

import java.io.IOException;
import java.util.List;

public interface ClientDao {
    Client add(Client client);

    void deleteById(Long id);
    Client findById(Long id) throws IOException;//File
    List<Client> getAll() throws IOException;
    Client getById(Long id);
    Client updateById(Long id,Client client) throws IOException;
    List<Client> showAll();
}

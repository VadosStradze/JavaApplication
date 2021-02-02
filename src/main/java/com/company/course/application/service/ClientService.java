package com.company.course.application.service;

import com.company.course.application.entity.Client;
import com.company.course.application.entity.Coach;

import java.io.IOException;
import java.util.List;

public interface ClientService {
    Client findById(Long id)  throws IOException;
    List<Client> getAll() throws  IOException;

    Client add(Client client);
    List<Client> showAll();
    Client getById(Long id);
    void deleteById(Long id);
    Client update(Long id,Client client);
}

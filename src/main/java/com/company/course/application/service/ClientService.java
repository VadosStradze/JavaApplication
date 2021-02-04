package com.company.course.application.service;

import com.company.course.application.entity.Client;

import java.io.IOException;
import java.util.List;

public interface ClientService {
    Client findById(Long id) throws IOException;


    Client add(Client client);

    List<Client> showAll();


    void deleteById(Long id);

    Client update(Long id, Client client);
}

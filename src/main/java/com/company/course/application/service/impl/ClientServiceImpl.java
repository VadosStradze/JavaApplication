package com.company.course.application.service.impl;

import com.company.course.application.dao.ClientDao;
import com.company.course.application.entity.Client;
import com.company.course.application.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao;

    public ClientServiceImpl(ClientDao clientDao){
        this.clientDao = clientDao;
    }


    @Override
    public Client findById(Long id) throws IOException {
        return clientDao.findById(id);
    }

    @Override
    public List<Client> getAll() throws IOException {

        return clientDao.getAll();
    }

    @Override
    public Client add(Client client) {
        clientDao.add(client);
        return client;
    }

    @Override
    public List<Client> showAll() {
        return clientDao.showAll();
    }

    @Override
    public Client getById(Long id) {/////////////////////////////////
        return clientDao.getById(id);
    }

    @Override
    public void deleteById(Long id) {
        clientDao.deleteById(id);
    }


    @Override
    public Client update(Long id, Client client) {
        try {
            Client newClient = clientDao.updateById(id, client);
            return newClient;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        return null;
    }
}
// TODO: 27.12.2020 Доделать DeleteById Client service

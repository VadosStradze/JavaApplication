package com.company.course.application.service.impl;

import com.company.course.application.dao.IDao;
import com.company.course.application.entity.Client;
import com.company.course.application.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientIService implements IService<Client> {

    private final IDao<Client> clientDao;

    public ClientIService(IDao<Client> clientDao) {
        this.clientDao = clientDao;
    }


    @Override
    public Client findById(Long id) {
        return clientDao.findById(id);
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
    public void deleteById(Long id) {
        clientDao.delete(id);
    }


    @Override
    public Client update(Long id, Client client) {
        try {
            Client newClient = clientDao.updateById(id, client);
            return newClient;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        return null;
    }
}
// TODO: 27.12.2020 Доделать DeleteById Client service

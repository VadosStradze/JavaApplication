package com.company.course.application.dao.impl;

import com.company.course.application.dao.ClientDao;
import com.company.course.application.entity.Client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Deprecated
public class ClientDaoImpl implements ClientDao {
    private List<Client> clientList = new ArrayList<>();
    private List<Client> toRemove = new ArrayList<>();

    @Override
    public Client add(Client client) {
        Long id = prepareUniqueId();
        client.setId(id);
        clientList.add(client);
        return client;
    }

    @Override
    public void deleteById(Long id) { ////запомнить позицию элемента , делаю ремову ипередаю позицию
        for (Client finder : clientList) {
            if (finder.getId().equals(id)) {
                System.out.println("Remove coach under id: " + finder.getId());
                toRemove.add(finder);
            }
        }
        clientList.removeAll(toRemove);


    }

    @Override
    public Client findById(Long id) throws IOException {
        for (Client finder : clientList) {
            if (finder.getId().equals(id)) {
                return finder;
            }
        }
        return null;

    }





    @Override
    public Client updateById(Long id, Client client) throws IOException {
        return null;
    }

    @Override
    public List<Client> showAll() {
        return null;
    }

   /* @Override
    public Client updateById(Long id, String newFirstName, String newLastName, String gender) throws IOException {
        return null;
    }*/



    private Long prepareUniqueId() {
        long max = -1;
        for (Client finder : clientList) {
            if (finder.getId() > max) {
                max = finder.getId();
            }
        }
        max++;

        return max;
    }
}

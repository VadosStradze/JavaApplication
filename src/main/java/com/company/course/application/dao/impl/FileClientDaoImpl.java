package com.company.course.application.dao.impl;

import com.company.course.application.dao.ClientDao;
import com.company.course.application.entity.Client;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public class FileClientDaoImpl implements ClientDao {
    private final String RESOURCE_FILE_CLIENT_TXT = "/home/vadim/course/src/main/java/com/company/course/application/resource/ClientList.txt";
    private final String RESOURCE_FILE_CLIENT_DELETE_TXT = "/home/vadim/course/src/main/java/com/company/course/application/resource/ClientListDeleted.txt";
    private final String RESOURCE_FILE_CLIENT_UPDATE_TXT = "/home/vadim/course/src/main/java/com/company/course/application/resource/ClientListUpdated.txt";

    @Override
    public Client add(Client client) {
        Long id = prepareUniqueId();
        client.setId(id);
        try (FileWriter writer = new FileWriter(RESOURCE_FILE_CLIENT_TXT, true)) {
            writer.write(client.getId() + " " + client.getFirstName() + " " + client.getLastName() + " " + client.getSex() + " " + client.getCoachId() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return client;

    }

    /*@Override
    public Client updateById(Long id, String newFirstName, String newLastName, String gender) throws IOException {
        File sourceFile = new File(RESOURCE_FILE_CLIENT_TXT);
        File updatedFile = new File(RESOURCE_FILE_CLIENT_UPDATE_TXT);
        String line = null;
        String fileString = getString(id);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(RESOURCE_FILE_CLIENT_TXT));
            BufferedWriter writer = new BufferedWriter(new FileWriter(RESOURCE_FILE_CLIENT_TXT));

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }*/


    @Override
    public void deleteById(Long id) { ////запомнить позицию элемента , делаю ремову ипередаю позицию
        File sourceFile = new File(RESOURCE_FILE_CLIENT_TXT);
        File outPutFile = new File(RESOURCE_FILE_CLIENT_DELETE_TXT);
        String line = null;
        String outputLine = getString(id);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outPutFile));
            while ((line = reader.readLine()) != null) {
                if (!line.equals(outputLine)) {
                    writer.write(line);
                    writer.newLine();
                }
            }
            reader.close();
            writer.close();
            sourceFile.delete();
            outPutFile.renameTo(sourceFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getString(Long id) {
        String value;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(RESOURCE_FILE_CLIENT_TXT));
            while ((value = reader.readLine()) != null) {
                if (Long.parseLong(value.split(" ")[0]) == id) {
                    return value;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * Для FILE
     **/
    @Override
    public Client findById(Long id) throws IOException {
        for (Client finder : showAll()) {
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
    public List<Client> showAll() throws IOException {
        List<Client> clientList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(RESOURCE_FILE_CLIENT_TXT));
        String value;
        while ((value = reader.readLine()) != null) {
            Client newClient = new Client();
            newClient.setId(Long.parseLong(value.split(" ")[0]));
            newClient.setFirstName(value.split(" ")[1]);
            newClient.setLastName(value.split(" ")[2]);
            newClient.setSex(value.split(" ")[3]);
            clientList.add(newClient);
        }
        return clientList;

    }


    private Long prepareUniqueId() {
        long max = -1;
        try {
            String value;
            BufferedReader reader = new BufferedReader(new FileReader(RESOURCE_FILE_CLIENT_TXT));
            while ((value = reader.readLine()) != null) {
                int id = Integer.parseInt(value.split(" ")[0]);
                if (id > max) {
                    max = id;
                }
            }
            max++;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return max;


    }
}


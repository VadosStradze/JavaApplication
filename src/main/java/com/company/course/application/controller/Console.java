package com.company.course.application.controller;

import com.company.course.application.entity.*;
import com.company.course.application.service.IService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class Console {

    private final IService<Coach> coachService;
    private final IService<Client> clientService;
    private final IService<Address> addressService;
    private final IService<Gym> gymService;

    public Console(IService<Coach> coachService, IService<Client> clientService, IService<Address> addressService, IService<Gym> gymService) {
        this.addressService = addressService;
        this.gymService = gymService;
        this.coachService = coachService;
        this.clientService = clientService;

    }

    public void menu() {


        //Связи
        /*clientTest.setCoachId(coachService.getById(0L).getId());
        clientTest1.setCoachId(coachService.getById(0L).getId());
        coachService.getById(0L).addClient(clientTest);
        coachService.getById(0L).addClient(clientTest1);*/


        allCommands();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            long id;
            int choose;
            System.out.println("Choose action:");
            System.out.print("> ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter coach FirstName:" + '\n' + "> ");
                    Coach coach = new Coach();
                    scanner.nextLine();
                    coach.setFirstName(scanner.nextLine());
                    System.out.println("Enter coach LastName:");
                    coach.setLastName(scanner.nextLine());
                    System.out.println("Enter experience:");
                    coach.setExperience(scanner.nextInt());
                    System.out.println("Choose coach gender:" + '\n' + "1: Man" + '\n' + "2: Woman");
                    choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            coach.setSex(Gender.man.getGender());
                            break;
                        case 2:
                            coach.setSex(Gender.woman.getGender());
                            break;
                        default:
                            coach.setSex("NO DATA");
                            break;
                    }
                    System.out.println("Enter coach gym");
                    Long coachGym = scanner.nextLong();
                    coach.setGymId(coachGym);

                    coachService.add(coach);
                    break;
                case 2:
                    System.out.print("Enter coach id to find:" + '\n' + "> ");
                    id = scanner.nextInt();
                    try {
                        System.out.println(coachService.findById(id));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Enter coach id to delete:" + '\n' + "> ");
                    id = scanner.nextInt();
                    coachService.deleteById(id);
                    break;
                case 4:
                    try {
                        for (Coach finder : coachService.showAll()) {
                            System.out.println(finder.toString());
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    Coach updateCoach = new Coach();
                    System.out.println("Enter coach id to update!");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new coach first name!");
                    String updateFirstName = scanner.nextLine();
                    updateCoach.setFirstName(updateFirstName);
                    System.out.println("Enter new coach last name !");
                    String updateLastName = scanner.nextLine();
                    updateCoach.setLastName(updateLastName);
                    System.out.println("Enter new coach experience !");
                    int updateExperience = scanner.nextInt();
                    updateCoach.setExperience(updateExperience);
                    System.out.println("Enter new coach gender!");
                    System.out.println("1:Man \n2:Woman");
                    String updateGender;
                    int value = scanner.nextInt();
                    if (value == 1) {
                        updateGender = Gender.man.getGender();
                        updateCoach.setSex(updateGender);
                    } else if (value == 2) {
                        updateGender = Gender.woman.getGender();
                        updateCoach.setSex(updateGender);
                    } else {
                        updateGender = "NO DATA";
                        updateCoach.setSex(updateGender);
                    }


                    coachService.update(id, updateCoach);
                    break;
                case 6:
                    System.out.print("Enter client FirstName:" + '\n' + "> ");
                    Client client = new Client();
                    //scanner.nextLine();
                    while (scanner.hasNext()) {
                        scanner.nextLine();
                        if (scanner.hasNextInt()) {
                            System.out.println("Error, enter string line!");
                        } else {
                            client.setFirstName(scanner.nextLine());
                            break;
                        }
                    }

                    System.out.println("Enter client LastName:");
                    while (scanner.hasNext()) {
                        //scanner.nextLine();
                        if (scanner.hasNextInt()) {
                            System.out.println("Error, enter string line!");

                        } else {
                            client.setLastName(scanner.nextLine());
                            break;
                        }
                    }

                    //client.setLastName(scanner.nextLine());
                    System.out.println("Choose client gender:" + '\n' + "1: Man" + '\n' + "2: Woman");
                    choose = scanner.nextInt();
                    switch (choose) {
                        case 1:
                            client.setSex(Gender.man.getGender());
                            break;
                        case 2:
                            client.setSex(Gender.woman.getGender());
                            break;
                        default:
                            client.setSex("NO DATA");
                            break;
                    }
                    System.out.println("Add coach ?");
                    System.out.println("1: Yes" + '\n' + "2: No");
                    value = scanner.nextInt();
                    if (value == 1) {
                        Long coachId = scanner.nextLong();
                        try {
                            //////////////////////////
                            if (coachId == coachService.findById(coachId).getId()) {
                                client.setCoachId(coachId);
                            } else {
                                System.out.println("No such coach in base!");
                            }
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    } else {
                        System.out.println("Ok, that all!");
                    }
                    clientService.add(client);
                    break;
                case 7:
                    System.out.print("Enter client id to find:" + '\n' + "> ");
                    id = scanner.nextInt();
                    try {
                        System.out.println(clientService.findById(id));
                    } catch (Exception e) {
                        System.out.println(e);
                    }


                    break;
                case 8:
                    System.out.print("Enter client id to delete:" + '\n' + "> ");
                    id = scanner.nextInt();
                    clientService.deleteById(id);
                    break;
                case 9:
                    try {
                        for (Client finder : clientService.showAll()) {
                            System.out.println(finder.toString());
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }


                    break;
                case 10:
                    Client updateClient = new Client();
                    System.out.println("Enter client id to update!");
                    id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new client first name!");
                    updateFirstName = scanner.nextLine();
                    updateClient.setFirstName(updateFirstName);
                    System.out.println("Enter new client last name !");
                    updateLastName = scanner.nextLine();
                    updateClient.setLastName(updateLastName);
                    System.out.println("Enter new client gender!");
                    System.out.println("1:Man \n2:Woman");

                    value = scanner.nextInt();
                    if (value == 1) {
                        updateGender = Gender.man.getGender();
                        updateClient.setSex(updateGender);
                    } else if (value == 2) {
                        updateGender = Gender.woman.getGender();
                        updateClient.setSex(updateGender);
                    } else {
                        System.out.println("Gender wasn't been updated!");
                    }
                    System.out.println("Enter new client coach ID:");
                    Long newCoachId = scanner.nextLong();
                    updateClient.setCoachId(newCoachId);


                    clientService.update(id, updateClient);
                    break;
                case 11:
                    Gym gym = new Gym();
                    scanner.nextLine();
                    System.out.println("Enter new gym name:");
                    String newGymName = scanner.nextLine();
                    gym.setGymName(newGymName);
                    System.out.println("Enter addressId:");
                    Long addressId = scanner.nextLong();
                    gym.setAddressId(addressId);
                    gymService.add(gym);
                    break;
                case 12:
                    Address address = new Address();
                    scanner.nextLine();
                    System.out.println("Enter gym city:");
                    String city = scanner.nextLine();
                    address.setCity(city);
                    System.out.println("Enter country");
                    String country = scanner.nextLine();
                    address.setCountry(country);
                    System.out.println("Enter gym address:");
                    String gymAddress = scanner.nextLine();
                    address.setAddress(gymAddress);
                    addressService.add(address);
                    break;
                case 13:
                    System.out.println("Enter coach id :");
                    Long newCoachGym = scanner.nextLong();
                    Coach newCoach = coachService.findById(newCoachGym);
                    System.out.println("Enter new coach gym id:");
                    Long newGymId = scanner.nextLong();
                    newCoach.setGymId(newGymId);
                    coachService.update(newCoach.getId(), newCoach);
                    List<Client> coachByIdList = clientService.findByCoachId(newCoachGym);
                    for (Client rez:coachByIdList) {
                        System.out.println(rez.toString());
                    }
                    for (Client finder:coachByIdList) {

                        finder.setCoachId(null);
                        clientService.update(finder.getId(),finder);

                    }
                    break;
                case 14:
                    break;
                case 0:
                    scanner.close();
                    break;


            }


        } while (choice != 0);


    }

    public void allCommands() {
        System.out.println("1 -> Add coach: ");
        System.out.println("2 -> Get coach by id: ");
        System.out.println("3 -> Delete coach by id: ");
        System.out.println("4 -> Show coach list: ");
        System.out.println("5 -> Update coach by id: ");
        System.out.println("6 -> Add client: ");
        System.out.println("7 -> Get client by id: ");
        System.out.println("8 -> Delete client by id: ");
        System.out.println("9 -> Show client list: ");
        System.out.println("10 -> Update client by id: ");
        System.out.println("0 -> Stop  the programme: ");
    }

}
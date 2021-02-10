package com.company.course.application.entity;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Coach implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String sex;

    public Coach(String firstName, String lastName, String sex, Integer experience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.experience = experience;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private Integer experience;
    private Set<Long> clientId;

    public Long getGymId() {
        return gymId;
    }

    public void setGymId(Long gymId) {
        this.gymId = gymId;
    }

    private Long gymId;

    public Set<Long> getClientId() {
        return clientId;
    }

    public void addClient(Client client) { /////////////////////////////Добавление айди клиента в коч
        clientId.add(client.getId());
    }

    public void setClientId(Set<Long> clientId) {
        this.clientId = clientId;
    }


    public Coach() {
        this.clientId = new HashSet<>();
    }

    public Coach(String firstName, String lastName, String sex, Integer experience, Long gymId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.experience = experience;
        this.gymId = gymId;
        this.clientId = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    /*public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coach coach = (Coach) o;
        return Objects.equals(id, coach.id) && Objects.equals(firstName, coach.firstName) && Objects.equals(lastName, coach.lastName) && Objects.equals(sex, coach.sex) && Objects.equals(experience, coach.experience) && Objects.equals(clientId, coach.clientId) && Objects.equals(gymId, coach.gymId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, sex, experience, clientId, gymId);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex='" + sex + '\'' +
                ", experience=" + experience +
                ", clientId=" + clientId +
                ", gymId=" + gymId +
                '}';
    }
}

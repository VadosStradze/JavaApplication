package com.company.course.application.entity;


import java.io.Serializable;
import java.util.Objects;


public class Client implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String sex;

    public Long getCoachId() {
        return coachId;
    }

    public void setCoachId(Long coachId) {
        this.coachId = coachId;
    }

    private Long coachId;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Client(String firstName, String lastName, String sex,Long coachId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.coachId = coachId;

    }

    public Client() {

    }

    @Override
    public String toString() {
        return "Client{" + "Id='"+ id+'\''+
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sex=" + sex + ", coachId="+ coachId+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return sex == client.sex && Objects.equals(id, client.id) && Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName) && Objects.equals(coachId, client.coachId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, sex, coachId);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


}

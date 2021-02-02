package com.company.course.application.entity;

public enum Gender {
    woman("FEMALE"),
    man("MALE");
    private String gender;

    Gender(String gender) {
        this.gender = gender;
    }
    public String getGender(){
        return gender;
    }

}

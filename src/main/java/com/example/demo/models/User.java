package com.example.demo.models;

import java.util.UUID;

public abstract class User {
    private String userId;
    private byte retries =0;
    private String name;
    private String surname;
    private String password;
    private String birthDate;
    private String userType;
    private String email;
    private boolean isActive = true ;



    //private boolean isActiveUser;
    //private boolean isClient;
    //private boolean isSeller;
    //private bolean isAdmin;
    //private ArrayList<DetalleVenta> cart;

    public User() {
    }
    public User(String password, String email) {
        this.password = password;
        this.email = email;
    }
    public User(String name, String surname, String password, String birthDate, String userType, String email) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.birthDate = birthDate;
        this.userType = userType;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void incrementFailedLogin(){
        this.retries++;
        if(this.retries>3){
            this.blockUser();
        }
    }
    public void resetRetries(){
        this.retries=0;
    }
    public void blockUser(){
        this.isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", userType='" + userType + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}



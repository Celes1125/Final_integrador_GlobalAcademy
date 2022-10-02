package com.example.demo.models;

import java.util.UUID;

public abstract class User {
    private String userId;
    private String name;
    private String surname;
    private String password;
    private String birthDate;
    private String userType;
    private String email;



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


    public User(String name, String surname, String password, String fecha_nacimiento, String tipo_usuario, String email) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.birthDate = fecha_nacimiento;
        this.userType = tipo_usuario;
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

    public String getTipo_usuario() {
        return userType;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.userType = tipo_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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



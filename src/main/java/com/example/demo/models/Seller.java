package com.example.demo.models;

import java.util.ArrayList;
import java.util.UUID;

public class Seller extends User {
    private String sellerId;

    private ArrayList<Sale> salesList;

    public Seller(String name, String surname, String password, String birthDate, String userType, String email) {
        super(name, surname, password, birthDate, userType, email);
        this.sellerId = UUID.randomUUID().toString();
        this.salesList = new ArrayList<>();
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public ArrayList<Sale> getSalesList() {
        return salesList;
    }

    public void setSalesList(ArrayList<Sale> salesList) {
        this.salesList = salesList;
    }

    @Override
    public String toString() {
        return "Seller{" +
                "sellerId='" + sellerId + '\'' +
                ", salesList=" + salesList +
                '}';
    }
}


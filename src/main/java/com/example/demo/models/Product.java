package com.example.demo.models;

import com.example.demo.SingletonCategories;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Product {
    private String productId;
    private String name;
    private Double price;
    private String category;
    private Seller seller;
    private int stock;


    public Product() {
    }

    public Product(String name, Double price, String category, Seller seller, int stock) {
        this.productId = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.category = category;
        this.seller = seller;
        this.stock = stock;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }



    public static Product CheckProduct(String productId, int quantity) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Product> products = cs.getProducts();
        return products.stream()
                .filter(p -> Objects.equals(p.getProductId(), productId))
                .filter(p -> p.getStock() >= quantity)
                .findFirst()
                .orElse(null);

    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", seller=" + seller +
                ", stock=" + stock +
                '}';
    }
}

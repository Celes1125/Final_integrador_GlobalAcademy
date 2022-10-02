package com.example.demo.models;
import java.util.UUID;

public class saleDetail {
    private final String saleDetailId;
    private Product product;
    private int units;
    private double amount;

    public saleDetail(Product product, int units) {
        this.saleDetailId = UUID.randomUUID().toString();
        this.product = product;
        this.units = units;
        this.amount = units * product.getPrice();
    }

    public String getSaleDetailId() {
        return saleDetailId;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getUnits() {
        return units;
    }
    public void setUnits(int units) {
        this.units = units;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "saleDetail{" +
                "saleDetailId='" + saleDetailId + '\'' +
                ", product=" + product +
                ", units=" + units +
                ", amount=" + amount +
                '}';
    }
}

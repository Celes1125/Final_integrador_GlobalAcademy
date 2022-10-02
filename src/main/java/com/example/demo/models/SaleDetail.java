package com.example.demo.models;
import java.util.UUID;

public class SaleDetail {
    private final String saleDetailId;
    private Product product;
    private int quantity;
    private double amount;

    public SaleDetail(Product product, int quantity) {
        this.saleDetailId = UUID.randomUUID().toString();
        this.product = product;
        this.quantity = quantity;
        this.amount = quantity * product.getPrice();
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
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
                ", units=" + quantity +
                ", amount=" + amount +
                '}';
    }
}

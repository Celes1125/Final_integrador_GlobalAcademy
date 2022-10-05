package com.example.demo.models;
import java.util.UUID;

public class SaleDetail {
    private final String saleDetailId;

    private final String clientId;
    private Product product;
    private int quantity;
    private double amount;

    public SaleDetail(String clientId, Product product, int quantity) {
        this.saleDetailId = UUID.randomUUID().toString();
        this.clientId = clientId;
        this.product = product;
        this.quantity = quantity;
        this.amount = quantity * product.getPrice();

    }

    public String getSaleDetailId() {
        return saleDetailId;
    }
    public String getClientId() { return  clientId;}
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
        return "SaleDetail{" +
                "saleDetailId='" + saleDetailId + '\'' +
                ", clientId='" + clientId + '\'' +
                ", product=" + product +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }
}

package com.example.demo.models;
import com.example.demo.SingletonCategories;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Sale {
    private String saleId;
    private Date saleDate;
    private Date estimatedDeliveryDate;
    private Date deliveryDate;
    private Client client;
    private ArrayList<SaleDetail> cart;
    private double totalPrice;


    public Sale(Client client) {
        this.client = client;


    }

    public void makeSale() {
        this.saleId = UUID.randomUUID().toString();
        this.saleDate = new Date();
        estimatedDelivery(saleDate);
        this.deliveryDate = null;
        this.cart = client.getClientCart();
        calculateTotal();
        recalculateStock();
    }


    private void recalculateStock() {
        ArrayList<SaleDetail> cart = client.getClientCart();
        cart.stream().forEach(
                d -> {
            Product.CheckProduct(d.getProduct().getProductId(), d.getQuantity());
            if(d != null){
                d.getProduct().setStock(d.getProduct().getStock()- d.getQuantity());
            }
        });

    }


    private void calculateTotal() {
        Double total= this.client.getClientCart().stream()
                .mapToDouble(sailDetail -> sailDetail.getAmount())
                .sum();
        this.totalPrice = total;
    }
    private void estimatedDelivery(Date saleDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(saleDate);
        calendar.add(Calendar.DAY_OF_YEAR, 10);
        this.estimatedDeliveryDate = calendar.getTime();
    }

    public String getSaleId() {
        return saleId;
    }

    public void setSaleId(String saleId) {
        this.saleId = saleId;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public Date getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Client getCliente() {
        return client;
    }

    public void setCliente(Client client) {
        this.client = client;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public ArrayList<SaleDetail> getCart() {
        return cart;
    }

    public void setCart(ArrayList<SaleDetail> cart) {
        this.cart = cart;
    }
    @Override
    public String toString() {
        return "Sale{" +
                "saleId='" + saleId + '\'' +
                ", saleDate=" + saleDate +
                ", estimatedDeliveryDate=" + estimatedDeliveryDate +
                ", deliveryDate=" + deliveryDate +
                ", client=" + client +
                ", cart=" + cart +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

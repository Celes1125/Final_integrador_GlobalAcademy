package com.example.demo.models;
import org.springframework.cglib.core.Local;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Venta {
    private String idVenta;
    private Date fechaDeVenta;
    private Date entregaEstimada;
    private Date entregaEfectiva;
    private Cliente cliente;
    private ArrayList<DetalleVenta> carrito;
    private double precioTotal;


    public Venta(Cliente cliente) {
        this.cliente = cliente;
        this.idVenta = UUID.randomUUID().toString();
        this.fechaDeVenta = new Date();
        this.entregaEstimada = entregaEstimada(fechaDeVenta);
        this.entregaEfectiva = null;
        this.carrito = cliente.getCarrito();
        this.precioTotal = calcularTotal();
    }

    private Date entregaEstimada(Date fechaDeVenta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaDeVenta);
        calendar.add(Calendar.DAY_OF_YEAR, 10);
        return calendar.getTime();
    }




    private double calcularTotal() {
       precioTotal=0;
       return precioTotal;
    }


    public String getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(String idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaDeVenta() {
        return fechaDeVenta;
    }

    public void setFechaDeVenta(Date fechaDeVenta) {
        this.fechaDeVenta = fechaDeVenta;
    }

    public Date getEntregaEstimada() {
        return entregaEstimada;
    }

    public void setEntregaEstimada(Date entregaEstimada) {
        this.entregaEstimada = entregaEstimada;
    }

    public Date getEntregaEfectiva() {
        return entregaEfectiva;
    }

    public void setEntregaEfectiva(Date entregaEfectiva) {
        this.entregaEfectiva = entregaEfectiva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", fechaDeVenta=" + fechaDeVenta +
                ", entregaEstimada=" + entregaEstimada +
                ", entregaEfectiva=" + entregaEfectiva +
                ", cliente=" + cliente +

                ", precioTotal=" + precioTotal +
                '}';
    }


}

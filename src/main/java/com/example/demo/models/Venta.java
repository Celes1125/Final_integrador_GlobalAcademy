package com.example.demo.models;
import com.example.demo.CategoriasSingleton;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Venta {
    private long idVenta;
    private Date fechaDeVenta;
    private SimpleDateFormat entregaEstimada;
    private SimpleDateFormat entregaEfectiva;

    private long idCliente;
    private ArrayList<DetalleVenta> detalleVenta;

    private double precioTotal;

    public Venta() {
    }

    public Venta(long idVenta, Date fechaDeVenta, SimpleDateFormat entregaEstimada, SimpleDateFormat entregaEfectiva, long idCliente, ArrayList<DetalleVenta> detalleVenta, double precioTotal) {
        this.idVenta = ventas.size() + 1;
        this.fechaDeVenta = new Date();
        this.entregaEstimada = new SimpleDateFormat("dd/MM/yyyy");
        this.entregaEfectiva = new SimpleDateFormat("dd/MM/yyyy");
        this.idCliente = idCliente;
        this.detalleVenta = detalleVenta;
        this.precioTotal = precioTotal;
    }

    CategoriasSingleton cs = CategoriasSingleton.getInstance();
    ArrayList<Venta> ventas = cs.getVentas();


    public long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(long idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaDeVenta() {
        return fechaDeVenta;
    }

    public void setFechaDeVenta(Date fechaDeVenta) {
        this.fechaDeVenta = fechaDeVenta;
    }

    public SimpleDateFormat getEntregaEstimada() {
        return entregaEstimada;
    }

    public void setEntregaEstimada(SimpleDateFormat entregaEstimada) {
        this.entregaEstimada = entregaEstimada;
    }

    public SimpleDateFormat getEntregaEfectiva() {
        return entregaEfectiva;
    }

    public void setEntregaEfectiva(SimpleDateFormat entregaEfectiva) {
        this.entregaEfectiva = entregaEfectiva;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList<DetalleVenta> getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(ArrayList<DetalleVenta> detalleVenta) {
        this.detalleVenta = detalleVenta;
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
                ", idCliente=" + idCliente +
                ", detalleVenta=" + detalleVenta +
                ", precioTotal=" + precioTotal +
                '}';
    }
}

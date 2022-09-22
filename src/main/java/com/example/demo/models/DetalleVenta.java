package com.example.demo.models;

import com.example.demo.CategoriasSingleton;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DetalleVenta {

    private long idDetalleVenta;
    private Cliente cliente;
    private Producto producto;
    private long cantidad;
    private double monto;


    public DetalleVenta() {
    }

    public DetalleVenta(Cliente cliente, Producto producto, long cantidad) {
        this.idDetalleVenta = detalles.size()+1;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
        this.monto = cantidad * producto.getPrecio();
    }

    public long getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(long idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" +
                "idDetalleVenta=" + idDetalleVenta +
                ", cliente=" + cliente +
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                ", monto=" + monto +
                '}';
    }

    CategoriasSingleton cs = CategoriasSingleton.getInstance();
    ArrayList<DetalleVenta> detalles = cs.getDetalles();
}

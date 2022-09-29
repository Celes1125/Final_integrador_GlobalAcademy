package com.example.demo.models;
import java.util.UUID;

public class DetalleVenta {
    private final String idDetalleVenta;
    private Producto producto;
    private long cantidad;
    private double monto;

    public DetalleVenta(Producto producto, long cantidad) {
        this.idDetalleVenta = UUID.randomUUID().toString();
        this.producto = producto;
        this.cantidad = cantidad;
        this.monto = cantidad * producto.getPrecio();
    }

    public String getIdDetalleVenta() {
        return idDetalleVenta;
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
                ", producto=" + producto +
                ", cantidad=" + cantidad +
                ", monto=" + monto +
                '}';
    }

}

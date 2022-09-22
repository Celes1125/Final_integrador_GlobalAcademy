package com.example.demo.models;

public class Producto {
    private long idProducto;
    private String nombreProducto;
    private Double precio;
    private String categoria;
    private Vendedor vendedor;
    private int stock;


    public Producto() {
    }

    public Producto(long idProducto, String nombreProducto, Double precio, String categoria, Vendedor vendedor, int stock) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.categoria = categoria;
        this.vendedor = vendedor;
        this.stock = stock;
    }

    public Producto(long idProducto) {
    }

    public long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                ", vendedor=" + vendedor +
                ", stock=" + stock +
                '}';
    }
}

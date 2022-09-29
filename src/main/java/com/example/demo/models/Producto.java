package com.example.demo.models;

import com.example.demo.CategoriasSingleton;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Producto {
    private String idProducto;
    private String nombreProducto;
    private Double precio;
    private String categoria;
    private Vendedor vendedor;
    private int stock;


    public Producto() {
    }

    public Producto(String nombreProducto, Double precio, String categoria, Vendedor vendedor, int stock) {
        this.idProducto = UUID.randomUUID().toString();
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.categoria = categoria;
        this.vendedor = vendedor;
        this.stock = stock;
    }



    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
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

    public static Producto ChecarProducto(String idProducto, long cantidad) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Producto> productos = cs.getProductos();
        return productos.stream()
                .filter(p -> Objects.equals(p.getIdProducto(), idProducto))
                .filter(p -> p.getStock() >= cantidad)
                .findFirst()
                .orElse(null);

    }
}

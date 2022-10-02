package com.example.demo.models;

import java.util.UUID;

public class Vendedor extends User {
    private String idVendedor;
    private int ventas;

    public Vendedor(String nombre, String apellido, String password, String fecha_nacimiento, String tipo_usuario, String email, int ventas) {
        super(nombre, apellido, password, fecha_nacimiento, tipo_usuario, email);
        this.idVendedor = UUID.randomUUID().toString();
        this.ventas = ventas;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(String idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }
}

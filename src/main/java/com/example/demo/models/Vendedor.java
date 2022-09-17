package com.example.demo.models;

public class Vendedor extends Usuario{
    private long idVendedor;
    private int ventas;

    public Vendedor(long idUsuario, String nombre, String apellido, String password, String fecha_nacimiento, String tipo_usuario, String email, long idVendedor, int ventas) {
        super(idUsuario, nombre, apellido, password, fecha_nacimiento, tipo_usuario, email);
        this.idVendedor = idVendedor;
        this.ventas = ventas;
    }

    public long getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }
}

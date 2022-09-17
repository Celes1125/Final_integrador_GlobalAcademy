package com.example.demo.models;

public class Cliente extends Usuario {
    private long idCliente;
    private int compras;

    public Cliente(long idUsuario, String nombre, String apellido, String password, String fecha_nacimiento, String tipo_usuario, String email, long idCliente, int compras) {
        super(idUsuario, nombre, apellido, password, fecha_nacimiento, tipo_usuario, email);
        this.idCliente = idCliente;
        this.compras = compras;
    }


    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public int getCompras() {
        return compras;
    }

    public void setCompras(int compras) {
        this.compras = compras;
    }

}

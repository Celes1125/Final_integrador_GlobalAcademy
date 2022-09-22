package com.example.demo.models;

public class Usuario {
    private long idUsuario;
    private String nombre;
    private String apellido;
    private String password;
    private String fecha_nacimiento;
    private String tipo_usuario;
    private String email;


    public Usuario() {
    }

    public Usuario(long idUsuario, String nombre, String apellido, String password, String fecha_nacimiento, String tipo_usuario, String email) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.fecha_nacimiento = fecha_nacimiento;
        this.tipo_usuario = tipo_usuario;
        this.email = email;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", password='" + password + '\'' +
                ", fecha_nacimiento=" + fecha_nacimiento +
                ", tipo_usuario='" + tipo_usuario + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}



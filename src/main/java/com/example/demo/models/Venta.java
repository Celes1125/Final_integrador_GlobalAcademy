package com.example.demo.models;


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
    }

    public void realizarVenta () {
        this.idVenta = UUID.randomUUID().toString();
        this.fechaDeVenta = new Date();
        entregaEstimada(fechaDeVenta);
        this.entregaEfectiva = null;
        this.carrito = cliente.getCarrito();
        //mostrarCarrito();
        calcularTotal();
        recalcularStock();
        cliente.vaciarCarrito();

    }

    private void recalcularStock() {
        ArrayList<DetalleVenta> carrito = cliente.getCarrito();
        carrito.stream().forEach(d -> {
            Producto.ChecarProducto(d.getProducto().getIdProducto(), d.getCantidad());
        });

    }

    /*private void mostrarCarrito () {
        ArrayList <DetalleVenta> carrito = new ArrayList<>();
        carrito = cliente.getCarrito();
        this.carrito = carrito;
    }*/
    private void calcularTotal() {
        Double total=0d;
        total= this.cliente.getCarrito().stream()
                .mapToDouble(detalleVenta -> detalleVenta.getMonto())
                .sum();
        this.precioTotal = total;
    }
    private void entregaEstimada(Date fechaDeVenta) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaDeVenta);
        calendar.add(Calendar.DAY_OF_YEAR, 10);
        this.entregaEstimada = calendar.getTime();
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
                ", carrito=" + carrito +
                ", precioTotal=" + precioTotal +
                '}';
    }


}

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
    private Client client;
    private ArrayList<saleDetail> carrito;
    private double precioTotal;


    public Venta(Client client) {
        this.client = client;
    }

    public void realizarVenta () {
        this.idVenta = UUID.randomUUID().toString();
        this.fechaDeVenta = new Date();
        entregaEstimada(fechaDeVenta);
        this.entregaEfectiva = null;
        this.carrito = client.getCarrito();
        //mostrarCarrito();
        calcularTotal();
        recalcularStock();
        client.vaciarCarrito();

    }

    private void recalcularStock() {
        ArrayList<saleDetail> carrito = client.getCarrito();
        carrito.stream().forEach(d -> {
            Product.CheckProduct(d.getProduct().getProductId(), d.getUnits());
        });

    }

    /*private void mostrarCarrito () {
        ArrayList <DetalleVenta> carrito = new ArrayList<>();
        carrito = cliente.getCarrito();
        this.carrito = carrito;
    }*/
    private void calcularTotal() {
        Double total=0d;
        total= this.client.getCarrito().stream()
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

    public Client getCliente() {
        return client;
    }

    public void setCliente(Client client) {
        this.client = client;
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
                ", cliente=" + client +
                ", carrito=" + carrito +
                ", precioTotal=" + precioTotal +
                '}';
    }


}

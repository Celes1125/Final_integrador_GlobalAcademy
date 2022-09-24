package com.example.demo.models;
import com.example.demo.CategoriasSingleton;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Venta {
    private long idVenta;
    private Date fechaDeVenta;
    private SimpleDateFormat entregaEstimada;
    private SimpleDateFormat entregaEfectiva;
    private Cliente cliente;
    private ArrayList<DetalleVenta> carrito;
    private double precioTotal;

    public Venta() {
    }

    public Venta(Cliente cliente) {
        this.cliente = cliente;
    }


    public Venta(SimpleDateFormat entregaEstimada, SimpleDateFormat entregaEfectiva, Cliente cliente, ArrayList<DetalleVenta> carrito, double precioTotal) {

        this.idVenta = ventas.size()+1;
        this.fechaDeVenta = new Date();
        this.entregaEstimada = cosecharEntregaEstimada();
        this.entregaEfectiva = cosecharEntregaEfectiva();
        this.cliente = cliente;
        this.carrito = agregarCarrito(cliente);
        this.precioTotal = calcularTotal();
    }

    private SimpleDateFormat cosecharEntregaEstimada() {
        entregaEstimada = new SimpleDateFormat("2022/11/23");
        return entregaEstimada;
    }

    private SimpleDateFormat cosecharEntregaEfectiva() {
        entregaEfectiva = new SimpleDateFormat("2022/11/23");
        return entregaEfectiva;
    }


    private ArrayList<DetalleVenta> agregarCarrito( Cliente cliente) {
        detalles.stream()
                .filter(d -> Objects.equals(d.getCliente(), cliente));

        return carrito;
    }

    private double calcularTotal() {
       precioTotal=100;
       return precioTotal;

    }


    public long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(long idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaDeVenta() {
        return fechaDeVenta;
    }

    public void setFechaDeVenta(Date fechaDeVenta) {
        this.fechaDeVenta = fechaDeVenta;
    }

    public SimpleDateFormat getEntregaEstimada() {
        return entregaEstimada;
    }

    public void setEntregaEstimada(SimpleDateFormat entregaEstimada) {
        this.entregaEstimada = entregaEstimada;
    }

    public SimpleDateFormat getEntregaEfectiva() {
        return entregaEfectiva;
    }

    public void setEntregaEfectiva(SimpleDateFormat entregaEfectiva) {
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

    public ArrayList<DetalleVenta> getCarrito() {
        return carrito;
    }

    public void setCarrito(ArrayList<DetalleVenta> carrito) {
        this.carrito = carrito;
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

    CategoriasSingleton cs = CategoriasSingleton.getInstance();
    ArrayList<Venta> ventas = cs.getVentas();
    ArrayList<DetalleVenta> detalles = cs.getDetalles();
}

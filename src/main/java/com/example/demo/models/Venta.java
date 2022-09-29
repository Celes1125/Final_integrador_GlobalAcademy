package com.example.demo.models;
import com.example.demo.CategoriasSingleton;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Venta {
    private long idVenta;
    private Date fechaDeVenta;
    private SimpleDateFormat entregaEstimada;
    private SimpleDateFormat entregaEfectiva;
    private Cliente cliente;
    private double precioTotal;

    public Venta() {
    }

    public Venta(Cliente cliente) {
        this.cliente = cliente;
    }


    public Venta(SimpleDateFormat entregaEstimada, SimpleDateFormat entregaEfectiva, Cliente cliente, double precioTotal) {

        this.idVenta = ventas.size()+1;
        this.fechaDeVenta = new Date();
        this.entregaEstimada = cosecharEntregaEstimada();
        this.entregaEfectiva = cosecharEntregaEfectiva();
        this.cliente = cliente;
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


    private double calcularTotal() {
       precioTotal=0;
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

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", fechaDeVenta=" + fechaDeVenta +
                ", entregaEstimada=" + entregaEstimada +
                ", entregaEfectiva=" + entregaEfectiva +
                ", cliente=" + cliente +

                ", precioTotal=" + precioTotal +
                '}';
    }

    CategoriasSingleton cs = CategoriasSingleton.getInstance();
    ArrayList<Venta> ventas = cs.getVentas();
    ArrayList<DetalleVenta> detalles = cs.getDetalles();
}

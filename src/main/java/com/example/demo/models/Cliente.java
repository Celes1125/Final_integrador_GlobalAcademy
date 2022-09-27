package com.example.demo.models;
import com.example.demo.CategoriasSingleton;
import java.util.ArrayList;
import java.util.Objects;

public class Cliente extends Usuario {
    private long idCliente;
    private static ArrayList<DetalleVenta> carrito;

    public Cliente(long idUsuario, String nombre, String apellido, String password, String fecha_nacimiento, String tipo_usuario, String email, long idCliente, ArrayList<DetalleVenta> carrito) {
        super(idUsuario, nombre, apellido, password, fecha_nacimiento, tipo_usuario, email);
        this.idCliente = idCliente;
        this.carrito = new ArrayList<>();
    }

    public long getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public ArrayList<DetalleVenta> getCarrito() {
        return carrito;
    }
    public static void SumarAlCarrito(DetalleVenta detalleVenta) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Cliente> clientes = cs.getClientes();
        carrito.add(detalleVenta);
        cs.setClientes(clientes);

    }

    public static void VaciarCarrito(){
        carrito=new ArrayList<>();
    }
    public static Cliente ChecarCliente(String password, String email) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Cliente> clientes = cs.getClientes();
        Cliente cliente = clientes.stream()
                .filter(c -> Objects.equals(c.getEmail(), email))
                .findFirst()
                .orElse(null);
        if (cliente != null && Objects.equals(cliente.getPassword(), password)) {
            return cliente;
        }else{
            return null;
        }

    }



}

package com.example.demo.models;
import com.example.demo.SingletonCategories;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class Client extends User {
    private String clientId;
    private static ArrayList<saleDetail> clientCart;


    public Client(String nombre, String apellido, String password, String fecha_nacimiento, String tipo_usuario, String email) {
        super(nombre, apellido, password, fecha_nacimiento, tipo_usuario, email);
        this.clientId = UUID.randomUUID().toString();
        this.clientCart = new ArrayList<>();
    }

    public String getClientId() {
        return clientId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }


    public static void SumarAlCarrito(saleDetail saleDetail) {
        SingletonCategories cs = SingletonCategories.getInstance();
        HashMap<String, ArrayList<saleDetail>> AllCartsList = cs.getAllCarts();




        carrito.add(saleDetail);
        cs.setClientes(clientes);

    }

    public void vaciarCarrito(){
        this.carrito=new ArrayList<>();
    }
    public static Client ChecarCliente(String password, String email) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Client> clients = cs.getClientes();
        Client client = clients.stream()
                .filter(c -> Objects.equals(c.getEmail(), email))
                .findFirst()
                .orElse(null);
        if (client != null && Objects.equals(client.getPassword(), password)) {
            return client;
        }else{
            return null;
        }

    }



}

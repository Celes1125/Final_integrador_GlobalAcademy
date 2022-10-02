package com.example.demo.models;
import com.example.demo.SingletonCategories;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Client extends User {
    private String clientId;
    private ArrayList<SaleDetail> clientCart;

    public Client(String name, String surname, String password, String birthDate, String userType, String email) {
        super(name, surname, password, birthDate, userType, email);
        this.clientId = UUID.randomUUID().toString();
        this.clientCart = new ArrayList<>();
    }


    public static void SumarAlCarrito(saleDetail saleDetail) {
        SingletonCategories cs = SingletonCategories.getInstance();
        //HashMap<String, ArrayList<saleDetail>> AllCartsList = cs.getAllCarts();




        carrito.add(saleDetail);
        cs.setClientes(clientes);

    }

    public void cleanCart(){
        this.clientCart=new ArrayList<>();
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


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public ArrayList<SaleDetail> getClientCart() {
        return clientCart;
    }

    public void setClientCart(ArrayList<SaleDetail> clientCart) {
        this.clientCart = clientCart;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId='" + clientId + '\'' +
                ", clientCart=" + clientCart +
                '}';
    }
}

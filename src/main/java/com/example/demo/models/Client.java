package com.example.demo.models;
import com.example.demo.SingletonCategories;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Client extends User {
    private final String clientId;
    private ArrayList<SaleDetail> clientCart;

    public Client(String name, String surname, String password, String birthDate, String userType, String email) {
        super(name, surname, password, birthDate, userType, email);
        this.clientId = UUID.randomUUID().toString();
        this.clientCart = new ArrayList<>();

    }



    public void cleanCart(){
        this.clientCart=new ArrayList<>();
    }
    public static Client CheckClient(String password, String email) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Client> clients = cs.getClients();
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

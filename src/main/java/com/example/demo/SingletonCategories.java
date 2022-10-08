package com.example.demo;
import com.example.demo.models.*;
import java.util.ArrayList;


public class SingletonCategories {
    //atributos
    private static SingletonCategories INSTANCE;
    private ArrayList<User> users;
    private ArrayList<Product> products;
    private ArrayList<Client> clients;
    private ArrayList<Seller> sellers;
    private ArrayList<Sale> sales;
    private ArrayList<SaleDetail> details;

    //constructor vacío pero con el atributo iniciado
    public SingletonCategories() {
        users = new ArrayList<>();
        products = new ArrayList<>();
        clients = new ArrayList<>();
        sellers = new ArrayList<>();
        sales = new ArrayList<>();
        details =  new ArrayList<>();

    }

    //método con el if...si no está esto no va a funcionar!!! este código instancia a INSTANCE si aún no ha sido instanciada, sino, llama a la que ya fue creada.

    public static SingletonCategories getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SingletonCategories();
        }
        return INSTANCE;
    }

    public ArrayList<User> getUsers(){
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<Product> getProducts () { return products;}

    public void setProducts(ArrayList<Product> products) { this.products = products;}

    public ArrayList<Client> getClients () {

        clients.forEach(client -> {
            ArrayList<SaleDetail> cart = new ArrayList<>();
            this.getDetails()
                    .stream()
                    .filter(
                            d -> d.getClientId().equals(client.getClientId()))
                            .forEach(cart::add);
            client.setClientCart(cart);
        });

        return clients;
    }

    public void setClients(ArrayList<Client> clients) { this.clients = clients;}

    public ArrayList<Seller> getSellers() { return sellers;}

    public void setSellers(ArrayList<Seller> sellers) { this.sellers = sellers;}

    public ArrayList<Sale> getSales() { return sales;}

    public void setSales(ArrayList<Sale> sales) { this.sales = sales;}

    public ArrayList<SaleDetail> getDetails() { return details;}

    public void setDetails(ArrayList<SaleDetail> details) { this.details = details;}


    }

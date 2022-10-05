package com.example.demo;
import com.example.demo.models.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SingletonCategories {
    //atributos
    private static SingletonCategories INSTANCE;
    private ArrayList<User> users;
    private ArrayList<Product> products;
    private ArrayList<Client> clients;
    private ArrayList<Seller> sellers;
    private ArrayList<Sale> sales;
    private ArrayList<SaleDetail> details;
    private HashMap<String, ArrayList<SaleDetail>> carts;

    //constructor vacío pero con el atributo iniciado
    public SingletonCategories() {
        users = new ArrayList<>();
        products = new ArrayList<>();
        clients = new ArrayList<>();
        sellers = new ArrayList<>();
        sales = new ArrayList<>();
        details =  new ArrayList<>();
        carts = new HashMap<>();
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

    public ArrayList<Client> getClients () { return clients;}

    public void setClients(ArrayList<Client> clients) { this.clients = clients;}

    public ArrayList<Seller> getSellers() { return sellers;}

    public void setSellers(ArrayList<Seller> sellers) { this.sellers = sellers;}

    public ArrayList<Sale> getSales() { return sales;}

    public void setSales(ArrayList<Sale> sales) { this.sales = sales;}

    public ArrayList<SaleDetail> getDetails() { return details;}

    public void setDetails(ArrayList<SaleDetail> details) { this.details = details;}

    public HashMap<String, ArrayList<SaleDetail>> getCarts() { return carts;}

    public void setCarts(HashMap<String, ArrayList<SaleDetail>> carts) { this.carts = carts;}
}

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
    private ArrayList<Vendedor> sellers;
    private ArrayList<Venta> sales;
    private ArrayList<saleDetail> details;
    private HashMap<String, ArrayList<saleDetail>> allCarts;

    //constructor vacío pero con el atributo iniciado
    public SingletonCategories() {
        users = new ArrayList<>();
        products = new ArrayList<>();
        clients = new ArrayList<>();
        sellers = new ArrayList<>();
        sales = new ArrayList<>();
        details =  new ArrayList<>();
        allCarts = new HashMap<>();
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

    public ArrayList<Product> getProductos () { return products;}

    public void setProductos(ArrayList<Product> products) { this.products = products;}

    public ArrayList<Client> getClientes () { return clients;}

    public void setClientes(ArrayList<Client> clients) { this.clients = clients;}

    public ArrayList<Vendedor> getSellers() { return sellers;}

    public void setSellers(ArrayList<Vendedor> sellers) { this.sellers = sellers;}

    public ArrayList<Venta> getSales() { return sales;}

    public void setSales(ArrayList<Venta> sales) { this.sales = sales;}

    public ArrayList<saleDetail> getDetails() { return details;}

    public void setDetails(ArrayList<saleDetail> details) { this.details = details;}

    public HashMap<String, ArrayList<saleDetail>> getAllCarts() { return allCarts;}

    public void setAllCarts(HashMap<String, ArrayList<saleDetail>> allCarts) { this.allCarts = allCarts;}
}

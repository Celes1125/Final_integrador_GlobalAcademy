package com.example.demo.services;
import com.example.demo.SingletonCategories;
import com.example.demo.models.Client;
import com.example.demo.models.Sale;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

import static com.example.demo.models.Sale.RestoreStock;


@Service
public class SaleService {


    public static ResponseEntity<ArrayList<Sale>> getAllSales() {
        SingletonCategories sc = SingletonCategories.getInstance();
        ArrayList<Sale> sales = sc.getSales();
        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    public ResponseEntity<Sale> createSale(String password, String email) {
        Client client = Client.CheckClient(password, email);
        if(client !=null){
            SingletonCategories sc = SingletonCategories.getInstance();
            ArrayList<Sale> sales = sc.getSales();
            Sale order = new Sale(client);
            order.makeOrder(order.getSaleId());
            sales.add(order);
            sc.setSales(sales);
            return new ResponseEntity<>(order, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Sale> confirmSale(String saleId) {
        Sale sale;
        sale = this.getSaleById(saleId).getBody();
        if(sale !=null){
            sale.setStatus("confirm");
            Sale.RefreshStock(sale);
            Sale.SendToDeliverySystem(sale);
            SingletonCategories sc = SingletonCategories.getInstance();
            ArrayList <Sale> sales = sc.getSales();
            sc.setSales(sales);
            return new ResponseEntity<>(sale, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<Sale> getSaleById(String id) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Sale> sales = cs.getSales();
        Sale sale = sales.stream()
                .filter(s -> Objects.equals(s.getSaleId(), id))
                .findFirst()
                .orElse(null);

        if(sale != null){
            return new ResponseEntity<>(sale, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Sale> cancelOrder(String saleId) {
        Sale sale;
        sale = this.getSaleById(saleId).getBody();

        if(sale !=null){
            SingletonCategories sc = SingletonCategories.getInstance();
            ArrayList<Sale> sales = sc.getSales();
            sale.setStatus("canceled");
            sc.setSales(sales);
            //Client.ClearCart(sale.getClient());
            return new ResponseEntity<>(sale, HttpStatus.OK);
            //trabar el confirmSale de alguna manera para esta saleId
            //trabar la edición de alguna manera...??
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Sale> cancelSale(String saleId) {
        Sale sale;
        sale = this.getSaleById(saleId).getBody();

        if(sale !=null){
            SingletonCategories sc = SingletonCategories.getInstance();
            ArrayList<Sale> sales = sc.getSales();
            sale.setStatus("canceled after confirm");
            sc.setSales(sales);
            RestoreStock(sale);
            return new ResponseEntity<>(sale, HttpStatus.OK);
            //trabar la edición de alguna manera...??
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

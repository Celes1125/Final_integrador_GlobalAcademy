package com.example.demo.services;
import com.example.demo.SingletonCategories;
import com.example.demo.models.Client;
import com.example.demo.models.Sale;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class SailService {


    public static ResponseEntity<ArrayList<Sale>> listarVentas() {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Sale> sales = cs.getSales();

        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    public ResponseEntity<Sale> createSale(String password, String email) {
        Client client = Client.ChecarCliente(password, email);
        if(client !=null){
            SingletonCategories cs = SingletonCategories.getInstance();
            ArrayList<Sale> sales = cs.getSales();
            Sale sale = new Sale(client);
            sale.makeSale();
            sales.add(sale);
            cs.setSales(sales);
            return new ResponseEntity<>(sale, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

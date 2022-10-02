package com.example.demo.services;
import com.example.demo.SingletonCategories;
import com.example.demo.models.Client;
import com.example.demo.models.Venta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class VentaService {


    public static ResponseEntity<ArrayList<Venta>> listarVentas() {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Venta> ventas = cs.getSales();

        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }

    public ResponseEntity<Venta> generarVenta(String password, String email) {
        Client client = Client.ChecarCliente(password, email);
        if(client !=null){
            SingletonCategories cs = SingletonCategories.getInstance();
            ArrayList<Venta> ventas = cs.getSales();
            Venta venta = new Venta(client);
            venta.realizarVenta();
            ventas.add(venta);
            cs.setSales(ventas);
            return new ResponseEntity<>(venta, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

package com.example.demo.services;
import com.example.demo.CategoriasSingleton;
import com.example.demo.models.Cliente;
import com.example.demo.models.Venta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class VentaService {


    public static ResponseEntity<ArrayList<Venta>> listarVentas() {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Venta> ventas = cs.getVentas();

        return new ResponseEntity<>(ventas, HttpStatus.OK);
    }

    public ResponseEntity<Venta> generarVenta(String password, String email) {
        Cliente cliente = Cliente.ChecarCliente(password, email);
        if(cliente!=null){
            CategoriasSingleton cs = CategoriasSingleton.getInstance();
            ArrayList<Venta> ventas = cs.getVentas();
            Venta venta = new Venta(cliente);
            cs.setVentas(ventas);
            return new ResponseEntity<>(venta, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

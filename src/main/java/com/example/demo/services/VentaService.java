package com.example.demo.services;
import com.example.demo.CategoriasSingleton;
import com.example.demo.models.Cliente;
import com.example.demo.models.Venta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;


@Service
public class VentaService {


    public ResponseEntity<Venta> generarVenta(String password, String email) {
        Cliente cliente = Cliente.ChecarCliente(password, email);
        if(cliente!=null){
            Venta venta = new Venta(cliente);
            return new ResponseEntity<>(venta, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

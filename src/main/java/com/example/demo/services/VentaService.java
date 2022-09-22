package com.example.demo.services;
import com.example.demo.CategoriasSingleton;
import com.example.demo.models.Cliente;
import com.example.demo.models.Usuario;
import com.example.demo.models.Venta;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;


@Service
public class VentaService {


    public ResponseEntity<Venta> generarVenta(String password, String email) {
        Cliente cliente = checarCliente(password, email);
        if(cliente!=null){
            Venta venta = new Venta(cliente);
            return new ResponseEntity<>(venta, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }





    }

    private Cliente checarCliente(String password, String email) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Cliente> clientes = cs.getClientes();
        Cliente cliente = clientes.stream()
                .filter(c -> Objects.equals(c.getEmail(), email))
                .findFirst()
                .orElse(null);
        if (cliente != null && cliente.getPassword()==password) {
            return cliente;
        }else{
            return null;
        }

    }
}

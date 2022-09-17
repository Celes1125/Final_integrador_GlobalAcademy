package com.example.demo.services;

import com.example.demo.CategoriasSingleton;
import com.example.demo.models.Cliente;
import com.example.demo.models.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class ClienteService {

    public ResponseEntity<ArrayList<Cliente>> crearCliente(Cliente nuevoCliente) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Cliente> clientes = cs.getClientes();

        Cliente cliente = clientes.stream()
                .filter(c -> Objects.equals(c.getIdCliente(), nuevoCliente.getIdCliente()))
                .findFirst()
                .orElse(null);

        if(cliente == null){
            clientes.add(nuevoCliente);
            cs.setClientes(clientes);
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ArrayList<Cliente>> listarClientes() {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Cliente> clientes = cs.getClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    public ResponseEntity<Cliente> verClienteXId(long id) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Cliente> clientes = cs.getClientes();
        Cliente cliente = clientes.stream()
                .filter(c -> Objects.equals(c.getIdCliente(), id))
                .findFirst()
                .orElse(null);

        if(cliente != null){
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Cliente> modificarCliente(Cliente nuevoCliente) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Cliente> clientes = cs.getClientes();
        Cliente cliente = clientes.stream()
                .filter(c -> Objects.equals(c.getIdCliente(), nuevoCliente.getIdCliente()))
                .findFirst()
                .orElse(null);

        if(cliente != null){
            cliente.setNombre(nuevoCliente.getNombre());
            cliente.setApellido(nuevoCliente.getApellido());
            cliente.setPassword(nuevoCliente.getPassword());
            cliente.setFecha_nacimiento(nuevoCliente.getFecha_nacimiento());
            cliente.setTipo_usuario(nuevoCliente.getTipo_usuario());
            cliente.setEmail(nuevoCliente.getEmail());
            cliente.setIdCliente(nuevoCliente.getIdCliente());
            cliente.setCompras(nuevoCliente.getCompras());
            return new ResponseEntity<>(nuevoCliente, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<ArrayList<Cliente>> eliminarCliente(long id) {

        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Cliente> clientes = cs.getClientes();

        Cliente cliente = clientes.stream()
                .filter(c -> Objects.equals(c.getIdCliente(), id))
                .findFirst()
                .orElse(null);

        if(cliente != null){
            clientes.remove(cliente);
            cs.setClientes(clientes);
            return new ResponseEntity<>(clientes, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}



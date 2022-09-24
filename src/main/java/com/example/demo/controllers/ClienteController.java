package com.example.demo.controllers;

import com.example.demo.models.Cliente;
import com.example.demo.models.Usuario;
import com.example.demo.services.ClienteService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    //CREAR CLIENTE desde /cliente

    @PostMapping(
            value = "/clientes",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<Cliente>> crearCliente(
            @RequestBody Cliente nuevoCliente

    ) {
        return clienteService.crearCliente(nuevoCliente);
    }

    //CONSULTAR LISTA DE CIENTES desde /clientes
    @GetMapping(
            value = "/clientes",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<Cliente>> listarClientes() {
        return clienteService.listarClientes();
    }

    //CONSULTAR UN CLIENTE ESPECÍFICO desde /clientes/{id}
    @GetMapping(
            value = "/clientes/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Cliente> verClienteXId(
            @PathVariable(name = "id") long id
    ) {
        return clienteService.verClienteXId(id);
    }

    //MODIFICAR UN CLIENTE desde /clientes/{id}

    @PutMapping(
            value = "/clientes",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Cliente> modificarCliente(
            @RequestBody Cliente nuevoCliente
    ) {
        return clienteService.modificarCliente(nuevoCliente);

    }

    //BORRAR UN CLIENTE ESPECÍFICO desde /clientes/{id}

    @DeleteMapping(
            value = "/clientes/{id}"

    )
    @ResponseBody
    public ResponseEntity<ArrayList<Cliente>> eliminarCliente(
            @PathVariable(name = "id") long id
    ) {
        return clienteService.eliminarCliente(id);

    }

    //ver carrito
    //ver historial de ventas




}

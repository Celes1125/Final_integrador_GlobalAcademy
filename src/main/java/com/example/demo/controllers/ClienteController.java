package com.example.demo.controllers;
import com.example.demo.models.Client;
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

    //CREAR CLIENTE desde /clientes
    @PostMapping(
            value = "/clientes",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<Client>> crearCliente(
            @RequestBody Client nuevoClient

    ) {
        return clienteService.crearCliente(nuevoClient);
    }

    //CONSULTAR LISTA DE CIENTES desde /clientes
    @GetMapping(
            value = "/clientes",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<Client>> listarClientes() {
        return clienteService.listarClientes();
    }

    //CONSULTAR UN CLIENTE ESPECÍFICO desde /clientes/{id}
    @GetMapping(
            value = "/clientes/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Client> verClienteXId(
            @PathVariable(name = "id") String id
    ) {
        return clienteService.verClienteXId(id);
    }

    //MODIFICAR UN CLIENTE desde /clientes/{id}
    @PutMapping(
            value = "/clientes",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Client> modificarCliente(
            @RequestBody Client nuevoClient
    ) {
        return clienteService.modificarCliente(nuevoClient);

    }

    //BORRAR UN CLIENTE ESPECÍFICO desde /clientes/{id}
    @DeleteMapping(
            value = "/clientes/{id}"

    )
    @ResponseBody
    public ResponseEntity<ArrayList<Client>> eliminarCliente(
            @PathVariable(name = "id") String id
    ) {
        return clienteService.eliminarCliente(id);

    }

    //ver carrito
    //ver historial de ventas




}

package com.example.demo.controllers;
import com.example.demo.models.Client;
import com.example.demo.services.ClientService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class ClientController {
    private final ClientService clientService;
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    //CREAR CLIENTE desde /clientes
    @PostMapping(
            value = "/clients",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<Client>> createClient(
            @RequestBody Client newClient

    ) {
        return clientService.createClient(newClient);
    }

    //CONSULTAR LISTA DE CIENTES desde /clients
    @GetMapping(
            value = "/clients",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<Client>> listClients() {
        return clientService.listCLients();
    }

    //CONSULTAR UN CLIENTE ESPECÍFICO desde /clients/{id}
    @GetMapping(
            value = "/clients/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Client> getClientById(
            @PathVariable(name = "id") String id
    ) {
        return clientService.getClientById(id);
    }

    //MODIFICAR UN CLIENTE desde /clients/{id}
    @PutMapping(
            value = "/clients",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Client> updateClient(
            @RequestBody Client newClient
    ) {
        return clientService.updateClient(newClient);

    }

    //BORRAR UN CLIENTE ESPECÍFICO desde /clients/{id}
    @DeleteMapping(
            value = "/clients/{id}"

    )
    @ResponseBody
    public ResponseEntity<ArrayList<Client>> deleteClient(
            @PathVariable(name = "id") String id
    ) {
        return clientService.deleteClient(id);

    }

    //ver carrito
    //ver historial de ventas




}

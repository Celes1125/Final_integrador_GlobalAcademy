package com.example.demo.controllers;
import com.example.demo.models.Vendedor;
import com.example.demo.services.VendedorService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class VendedorController {


    private final VendedorService vendedorService;

    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    //CREAR VENDEDOR desde /vendedores

    @PostMapping(
            value = "/vendedores",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<Vendedor>> crearVendedor(
            @RequestBody Vendedor nuevoVendedor

    ) {
        return vendedorService.crearVendedor(nuevoVendedor);
    }

    //CONSULTAR LISTA DE VENDEDORES desde /vendedores
    @GetMapping(
            value = "/vendedores",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<Vendedor>> listarVendedores() {
        return vendedorService.listarVendedores();
    }

    //CONSULTAR UN VENDEDOR ESPECÍFICO desde /vendedores/{id}
    @GetMapping(
            value = "/vendedores/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Vendedor> verVendedorXId(
            @PathVariable(name = "id") long id
    ) {
        return vendedorService.verVendedorXId(id);
    }

    //MODIFICAR UN VENDEDOR desde /vendedores/{id}

    @PutMapping(
            value = "/vendedores",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Vendedor> modificarVendedor(
            @RequestBody Vendedor nuevoVendedor
    ) {
        return vendedorService.modificarVendedor(nuevoVendedor);

    }

    //BORRAR UN VENDEDOR ESPECÍFICO desde /vendedores/{id}

    @DeleteMapping(
            value = "/vendedores/{id}"

    )
    @ResponseBody
    public ResponseEntity<ArrayList<Vendedor>> eliminarVendedor(
            @PathVariable(name = "id") long id
    ) {
        return vendedorService.eliminarVendedor(id);

    }

     //ver listax de productos del vendedor
    //ver sus productos vendidos, ordenar x fecha y precio

}

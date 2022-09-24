package com.example.demo.controllers;


import com.example.demo.models.DetalleVenta;
import com.example.demo.services.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DetalleVentaController {
    @Autowired
    private final DetalleVentaService detalleVentaService;

    public DetalleVentaController(DetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    @PostMapping(
            value="/detalles",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<DetalleVenta> sumarAlCarrito (
            @RequestHeader (value="password") String password,
            @RequestHeader (value="email") String email,
            @RequestParam (name="idProducto") long idProducto,
            @RequestParam (name="cantidad") long cantidad
    ){
        return DetalleVentaService.sumarAlCarrito(password, email, idProducto, cantidad);
    }
}

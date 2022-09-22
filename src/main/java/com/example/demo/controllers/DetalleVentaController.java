package com.example.demo.controllers;


import com.example.demo.models.DetalleVenta;
import com.example.demo.models.Producto;
import com.example.demo.services.DetalleVentaService;
import com.example.demo.services.UsuarioService;
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
            value="/detalle",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<DetalleVenta> generarDetalleVenta (
            @RequestParam (name="idCliente") long idCliente,
            @RequestParam (name="idProducto") long idProducto,
            @RequestParam (name="cantidad") long cantidad
    ){
        return DetalleVentaService.generarDetalleVenta(idCliente, idProducto, cantidad);
    }
}

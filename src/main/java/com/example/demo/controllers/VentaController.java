package com.example.demo.controllers;

import com.example.demo.models.Venta;
import com.example.demo.services.VentaService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class VentaController {
    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }
    @PostMapping(
            value="/ventas",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Venta> generarVenta (
            @RequestHeader (value="password") String password,
            @RequestHeader (value="email") String email


    ){
        return ventaService.generarVenta(password, email);
    }

    @GetMapping (
            value="/ventas",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<Venta>> listarVentas (){
        return VentaService.listarVentas();
    }

    //crud...vender, cancelar, despachar????
    //ver ventas por fecha
    //ver ventas por monto total

}

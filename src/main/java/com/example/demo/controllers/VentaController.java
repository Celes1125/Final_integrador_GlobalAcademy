package com.example.demo.controllers;

import com.example.demo.models.Sale;
import com.example.demo.services.SaleService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class VentaController {
    private final SaleService saleService;

    public VentaController(SaleService saleService) {
        this.saleService = saleService;
    }
    @PostMapping(
            value="/ventas",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Sale> generarVenta (
            @RequestHeader (value="password") String password,
            @RequestHeader (value="email") String email


    ){
        return saleService.createSale(password, email);
    }

    @GetMapping (
            value="/ventas",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<Sale>> listarVentas (){
        return SaleService.listarVentas();
    }

    //crud...vender, cancelar, despachar????
    //ver ventas por fecha
    //ver ventas por monto total

}

package com.example.demo.controllers;

import com.example.demo.models.Sale;
import com.example.demo.services.SaleService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class SaleController {
    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }
    @PostMapping(
            value="/sales",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Sale> createSale(
            @RequestHeader (value="password") String password,
            @RequestHeader (value="email") String email


    ){
        return saleService.createSale(password, email);
    }

    @GetMapping (
            value="/sales",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<Sale>> getAllSales(){
        return saleService.getAllSales();
    }


    @PostMapping (
            value="/sales/confirm",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Sale> confirmSale(
            @RequestHeader (value="saleId") String saleId
    ){
        return saleService.confirmSale(saleId);
    }

    @GetMapping (
            value="/sales/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Sale> getSaleById(
            @PathVariable(name = "id") String id
    ){
        return saleService.getSaleById(id);
    }

    @PutMapping (
            value = "/sales/cancel",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Sale> cancelOrder(
            @RequestHeader (value= "saleId") String saleId
    ){
        return saleService.cancelOrder(saleId);
    }


    //crud...vender, cancelar, despachar????
    //ver ventas por fecha
    //ver ventas por monto total

}

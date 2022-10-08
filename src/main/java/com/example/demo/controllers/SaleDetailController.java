package com.example.demo.controllers;
import com.example.demo.models.SaleDetail;
import com.example.demo.services.SaleDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class SaleDetailController {
    @Autowired
    private final SaleDetailService saleDetailService;
    public SaleDetailController(SaleDetailService saleDetailService) {
        this.saleDetailService = saleDetailService;
    }
    @PostMapping(
            value="/details",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity <ArrayList<SaleDetail>> addToCart(
            @RequestHeader (value="password") String password,
            @RequestHeader (value="email") String email,
            @RequestParam (name="productId") String ProductId,
            @RequestParam (name="quantity") int quantity
    ){
        return SaleDetailService.addToCart(password, email, ProductId, quantity);
    }
}

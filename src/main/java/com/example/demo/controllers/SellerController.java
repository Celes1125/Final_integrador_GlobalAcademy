package com.example.demo.controllers;
import com.example.demo.models.Seller;
import com.example.demo.services.SellerService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class SellerController {
    private final SellerService sellerService;
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    //CREAR VENDEDOR desde /sellers

    @PostMapping(
            value = "/sellers",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<Seller>> createSeller(
            @RequestBody Seller newSeller
    ) {
        return sellerService.createSeller(newSeller);
    }

    //CONSULTAR LISTA DE VENDEDORES desde /sellers
    @GetMapping(
            value = "/sellers",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<Seller>> listSellers() {
        return sellerService.listSellers();
    }

    //CONSULTAR UN VENDEDOR ESPECÍFICO desde /sellers/{id}
    @GetMapping(
            value = "/sellers/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Seller> getSellerById(
            @PathVariable(name = "id") String id
    ) {
        return sellerService.getSellerById(id);
    }

    //MODIFICAR UN VENDEDOR desde /sellers/{id}

    @PutMapping(
            value = "/sellers",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Seller> updateSeller(
            @RequestBody Seller newSeller
    ) {
        return sellerService.updateSeller(newSeller);

    }

    //BORRAR UN VENDEDOR ESPECÍFICO desde /sellers/{id}

    @DeleteMapping(
            value = "/sellers/{id}"

    )
    @ResponseBody
    public ResponseEntity<ArrayList<Seller>> deleteSeller(
            @PathVariable(name = "id") long id
    ) {
        return sellerService.deleteSeller(id);

    }

     //ver listax de productos del vendedor
    //ver sus productos vendidos, ordenar x fecha y precio

}

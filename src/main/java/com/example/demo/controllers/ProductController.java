package com.example.demo.controllers;
import com.example.demo.services.ProductService;
import com.example.demo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //CREAR PRODUCTO desde /products

    @PostMapping(
            value = "/products",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<Product>> createProduct(
            @RequestBody Product newProduct

    ) {
        return productService.createProduct(newProduct);
    }

    //CONSULTAR LISTA DE PRODUCTOS desde /products
    @GetMapping(
            value = "/products",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<Product>> listProducts() {
        return productService.listProducts();
    }

    //CONSULTAR UN PRODUCTO ESPECÍFICO desde /products/{id}
    @GetMapping(
            value = "/products/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Product> getProductById(
            @PathVariable(name = "id") String id
    ) {
        return productService.getProductById(id);
    }

    //MODIFICAR UN PRODUCTO desde /products/{id}

    @PutMapping(
            value = "/products",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Product> updateProduct(
            @RequestBody Product newProduct
    ) {
        return productService.updateProduct(newProduct);

    }

    //BORRAR UN PRODUCTO ESPECÍFICO desde /products/{id}

    @DeleteMapping(
            value = "/products/{id}"

    )
    @ResponseBody
    public ResponseEntity<ArrayList<Product>> deleteProduct(
            @PathVariable(name = "id") String id
    ) {
        return productService.deleteProduct(id);

    }
    //FILTROS DE CONSULTA DE PRODUCTO SEGUN DISTINTOS ATRIBUTOS (usar stream lambda)
    //ver producto x categoria
    //ver producto x precio / rango de precio?
    //ver producto x vendedor
    //ver producto x nombre, ordenar alfabéticamente...
    //ordenar productos de acuerdo a su precio, descendente y ascendente
    //ordenar productos por relevancia (usando como criterio el número de ventas asociado al producto...)



}


package com.example.demo.controllers;
import com.example.demo.services.ProductoService;
import com.example.demo.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
public class ProductoController {

    @Autowired
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    //CREAR PRODUCTO desde /productos

    @PostMapping(
            value = "/productos",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<Product>> crearProducto(
            @RequestBody Product nuevoProduct

    ) {
        return productoService.crearProducto(nuevoProduct);
    }

    //CONSULTAR LISTA DE PRODUCTOS desde /productos
    @GetMapping(
            value = "/productos",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<Product>> listarProductos() {
        return productoService.listarProductos();
    }

    //CONSULTAR UN PRODUCTO ESPECÍFICO desde /productos/{id}
    @GetMapping(
            value = "/productos/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Product> verProductoXId(
            @PathVariable(name = "id") String id
    ) {
        return productoService.verProductoXId(id);
    }

    //MODIFICAR UN PRODUCTO desde /productos/{id}

    @PutMapping(
            value = "/productos",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Product> modificarProducto(
            @RequestBody Product nuevoProduct
    ) {
        return productoService.modificarProducto(nuevoProduct);

    }

    //BORRAR UN PRODUCTO ESPECÍFICO desde /productos/{id}

    @DeleteMapping(
            value = "/productos/{id}"

    )
    @ResponseBody
    public ResponseEntity<ArrayList<Product>> bajaProducto(
            @PathVariable(name = "id") String id
    ) {
        return productoService.bajaProducto(id);

    }
    //FILTROS DE CONSULTA DE PRODUCTO SEGUN DISTINTOS ATRIBUTOS (usar stream lambda)
    //ver producto x categoria
    //ver producto x precio / rango de precio?
    //ver producto x vendedor
    //ver producto x nombre, ordenar alfabéticamente...
    //ordenar productos de acuerdo a su precio, descendente y ascendente
    //ordenar productos por relevancia (usando como criterio el número de ventas asociado al producto...)



}


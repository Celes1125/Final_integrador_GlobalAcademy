package com.example.demo.Controllers;

import com.example.demo.Services.ProductoService;
import com.example.demo.Services.UsuarioService;
import com.example.demo.models.Producto;
import com.example.demo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    //CREAR PRODUCTOS desde /productos

    @PostMapping(
            value = "/productos",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<Producto>> crearProducto(
            @RequestBody Producto producto

    ) {
        return new ResponseEntity<>(productoService.crearProducto(producto), HttpStatus.CREATED);
    }

    //CONSULTAR LISTA DE PRODUCTOS desde /productos
    @GetMapping(
            value = "/productos",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ArrayList<Producto> listarProductos() {
        return productoService.listarProductos();
    }

    //CONSULTAR UN PRODUCTO ESPECÍFICO desde /productos/{id}
    @GetMapping(
            value = "/productos/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<?> verProductoXId(
            @PathVariable(name = "id") int id
    ) {
        return productoService.verProductoXId(id);
    }

    //MODIFICAR UN PRODUCTO desde /productos/{id}

    @PutMapping(
            value = "/productos/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public Producto modificarProducto(
            @PathVariable(name = "id") int id,
            @RequestBody Producto producto
    ) {
        productoService.modificarProducto(id, producto);
        return producto;
    }

    //BORRAR UN PRODUCTO ESPECÍFICO desde /usuarios/{id}

    @DeleteMapping(
            value = "/productos/{id}"

    )
    @ResponseBody
    public ResponseEntity<ArrayList<Producto>> bajaProducto(
            @PathVariable(name = "id") int id
    ) {
        return new ResponseEntity<>(productoService.bajaProducto(id), HttpStatus.OK);

    }


}

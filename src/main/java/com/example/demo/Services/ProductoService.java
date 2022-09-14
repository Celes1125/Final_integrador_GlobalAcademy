package com.example.demo.Services;

import com.example.demo.CategoriasSingleton;
import com.example.demo.models.Producto;
import com.example.demo.models.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class ProductoService {

    public ArrayList<Producto> crearProducto(Producto producto) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Producto> productos = cs.getProductos();
        productos.add(producto);
        cs.setProductos(productos);
        return productos;

    }

    public ArrayList<Producto> listarProductos() {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Producto> productos = cs.getProductos();
        return productos;
    }

    public ResponseEntity<?> verProductoXId(int id) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Producto> productos = cs.getProductos();
        try {
            return new ResponseEntity<>(productos.get(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public void modificarProducto(int id, Producto producto) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Producto> productos = cs.getProductos();
        productos.stream()
                .map(p -> {
                    if (p.getIdProducto() == id) {
                        p.setNombreProducto(producto.getNombreProducto());
                        p.setPrecio(producto.getPrecio());
                        p.setCategoria(producto.getCategoria());
                        p.setStock(producto.getStock());
                    }
                    return p;
                })
                .collect(Collectors.toList());
    }

    public ArrayList<Producto> bajaProducto(int id) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Producto> productos = cs.getProductos();
        productos.remove(id);
        cs.setProductos(productos);
        return productos;


    }


}

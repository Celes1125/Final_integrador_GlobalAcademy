package com.example.demo.services;

import com.example.demo.CategoriasSingleton;
import com.example.demo.models.Cliente;
import com.example.demo.models.DetalleVenta;
import com.example.demo.models.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class DetalleVentaService {
    public static ResponseEntity<DetalleVenta> sumarAlCarrito(String password, String email, long idProducto, long cantidad) {
        Cliente cliente = checarCliente(password, email);
        Producto producto = checarProducto(idProducto, cantidad);
        if(cliente!=null && producto !=null){//ACÁ DESPUÉS VER DE USAR MEJOR UN SWITCH CASE U OTRA COSA PARA QUE DEVUELVA BIEN EL ERROR...
            DetalleVenta detalleVenta = new DetalleVenta(cliente, producto, cantidad);
            return new ResponseEntity<>(detalleVenta, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    private static Cliente checarCliente(String password, String email) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Cliente> clientes = cs.getClientes();
        Cliente cliente = clientes.stream()
                .filter(c -> Objects.equals(c.getEmail(), email))
                .findFirst()
                .orElse(null);
        if (cliente != null && Objects.equals(cliente.getPassword(), password)) {
            return cliente;
        }else{
            return null;
        }

    }

    public static Producto checarProducto(long idProducto, long cantidad) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Producto> productos = cs.getProductos();
        Producto producto = productos.stream()
                .filter(p -> Objects.equals(p.getIdProducto(), idProducto))
                .findFirst()
                .orElse(null);
        if(producto!=null && producto.getStock()>=cantidad){
            return producto;
        }else{
            return null;
        }
    }
}

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
    public static ResponseEntity <ArrayList<DetalleVenta>> sumarAlCarrito(String password, String email, long idProducto, long cantidad) {
        Cliente cliente= Cliente.ChecarCliente(password, email);
        Producto producto = Producto.ChecarProducto(idProducto, cantidad);
        if(cliente!=null && producto !=null){//ACÁ DESPUÉS VER DE USAR MEJOR UN SWITCH CASE U OTRA COSA PARA QUE DEVUELVA BIEN EL ERROR...
            DetalleVenta detalleVenta = new DetalleVenta(producto, cantidad);
            Cliente.SumarAlCarrito(detalleVenta);

            return new ResponseEntity<>(cliente.getCarrito(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

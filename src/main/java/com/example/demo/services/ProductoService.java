
package com.example.demo.services;
import com.example.demo.CategoriasSingleton;
import com.example.demo.models.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class ProductoService {

    public ResponseEntity<ArrayList<Producto>> crearProducto(Producto nuevoProducto) {

        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Producto> productos = cs.getProductos();
        //le saqué el chequeo por id porque no le veo el sentido luego de que el id se genere por UUID...
        Producto producto = new Producto(nuevoProducto.getNombreProducto(), nuevoProducto.getPrecio(), nuevoProducto.getCategoria(), nuevoProducto.getVendedor(), nuevoProducto.getStock());
        productos.add(producto);
        cs.setProductos(productos);
        return new ResponseEntity<>(productos, HttpStatus.OK);

    }

    public ResponseEntity<ArrayList<Producto>> listarProductos() {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Producto> productos = cs.getProductos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    public ResponseEntity<Producto> verProductoXId(String id) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Producto> productos = cs.getProductos();
        Producto producto = productos.stream()
                .filter(p -> Objects.equals(p.getIdProducto(), id))
                .findFirst()
                .orElse(null);

        if(producto != null){
            return new ResponseEntity<>(producto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Producto> modificarProducto(Producto nuevoProducto) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Producto> productos = cs.getProductos();
        Producto producto = productos.stream()
                .filter(p -> Objects.equals(p.getIdProducto(), nuevoProducto.getIdProducto()))
                .findFirst()
                .orElse(null);

        if(producto != null){
            producto.setNombreProducto(nuevoProducto.getNombreProducto());
            producto.setPrecio(nuevoProducto.getPrecio());
            producto.setCategoria(nuevoProducto.getCategoria());
            producto.setStock(nuevoProducto.getStock());
            return new ResponseEntity<>(nuevoProducto, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<ArrayList<Producto>> bajaProducto(String id) {

        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Producto> productos = cs.getProductos();

        Producto producto = productos.stream()
                .filter(p -> Objects.equals(p.getIdProducto(), id))
                .findFirst()
                .orElse(null);

        if(producto != null){
            productos.remove(producto);
            cs.setProductos(productos);
            return new ResponseEntity<>(productos, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }








    }
}

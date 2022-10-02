
package com.example.demo.services;
import com.example.demo.SingletonCategories;
import com.example.demo.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class ProductoService {

    public ResponseEntity<ArrayList<Product>> crearProducto(Product nuevoProduct) {

        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Product> products = cs.getProductos();
        //le saqué el chequeo por id porque no le veo el sentido luego de que el id se genere por UUID...
        Product product = new Product(nuevoProduct.getName(), nuevoProduct.getPrice(), nuevoProduct.getCategory(), nuevoProduct.getSeller(), nuevoProduct.getStock());
        products.add(product);
        cs.setProductos(products);
        return new ResponseEntity<>(products, HttpStatus.OK);

    }

    public ResponseEntity<ArrayList<Product>> listarProductos() {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Product> products = cs.getProductos();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    public ResponseEntity<Product> verProductoXId(String id) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Product> products = cs.getProductos();
        Product product = products.stream()
                .filter(p -> Objects.equals(p.getProductId(), id))
                .findFirst()
                .orElse(null);

        if(product != null){
            return new ResponseEntity<>(product, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Product> modificarProducto(Product nuevoProduct) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Product> products = cs.getProductos();
        Product product = products.stream()
                .filter(p -> Objects.equals(p.getProductId(), nuevoProduct.getProductId()))
                .findFirst()
                .orElse(null);

        if(product != null){
            product.setName(nuevoProduct.getName());
            product.setPrice(nuevoProduct.getPrice());
            product.setCategory(nuevoProduct.getCategory());
            product.setStock(nuevoProduct.getStock());
            return new ResponseEntity<>(nuevoProduct, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<ArrayList<Product>> bajaProducto(String id) {

        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Product> products = cs.getProductos();

        Product product = products.stream()
                .filter(p -> Objects.equals(p.getProductId(), id))
                .findFirst()
                .orElse(null);

        if(product != null){
            products.remove(product);
            cs.setProductos(products);
            return new ResponseEntity<>(products, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }








    }
}

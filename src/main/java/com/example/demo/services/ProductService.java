
package com.example.demo.services;
import com.example.demo.SingletonCategories;
import com.example.demo.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class ProductService {

    public ResponseEntity<ArrayList<Product>> createProduct(Product newProduct) {

        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Product> products = cs.getProducts();
        //le saqué el chequeo por id porque no le veo el sentido luego de que el id se genere por UUID...
        Product product = new Product(newProduct.getName(), newProduct.getPrice(), newProduct.getCategory(), newProduct.getSeller(), newProduct.getStock());
        products.add(product);
        cs.setProducts(products);
        return new ResponseEntity<>(products, HttpStatus.OK);

    }

    public ResponseEntity<ArrayList<Product>> listProducts() {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Product> products = cs.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    public ResponseEntity<Product> getProductById(String id) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Product> products = cs.getProducts();
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

    public ResponseEntity<Product> updateProduct(Product newProduct) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Product> products = cs.getProducts();
        Product product = products.stream()
                .filter(p -> Objects.equals(p.getProductId(), newProduct.getProductId()))
                .findFirst()
                .orElse(null);

        if(product != null){
            product.setName(newProduct.getName());
            product.setPrice(newProduct.getPrice());
            product.setCategory(newProduct.getCategory());
            product.setStock(newProduct.getStock());
            return new ResponseEntity<>(newProduct, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<ArrayList<Product>> deleteProduct(String id) {

        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Product> products = cs.getProducts();

        Product product = products.stream()
                .filter(p -> Objects.equals(p.getProductId(), id))
                .findFirst()
                .orElse(null);

        if(product != null){
            products.remove(product);
            cs.setProducts(products);
            return new ResponseEntity<>(products, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }








    }
}

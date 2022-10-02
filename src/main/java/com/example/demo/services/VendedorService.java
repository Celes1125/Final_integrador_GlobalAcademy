package com.example.demo.services;
import com.example.demo.SingletonCategories;
import com.example.demo.models.Vendedor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class VendedorService {
    public ResponseEntity<ArrayList<Vendedor>> crearVendedor(Vendedor nuevoVendedor) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Vendedor> vendedores = cs.getSellers();

        Vendedor vendedor = vendedores.stream()
                .filter(v -> Objects.equals(v.getIdVendedor(), nuevoVendedor.getIdVendedor()))
                .findFirst()
                .orElse(null);

        if(vendedor == null){
            vendedores.add(nuevoVendedor);
            cs.setSellers(vendedores);
            return new ResponseEntity<>(vendedores, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ArrayList<Vendedor>> listarVendedores() {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Vendedor> vendedores = cs.getSellers();
        return new ResponseEntity<>(vendedores, HttpStatus.OK);
    }

    public ResponseEntity<Vendedor> verVendedorXId(long id) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Vendedor> vendedores = cs.getSellers();
        Vendedor vendedor = vendedores.stream()
                .filter(c -> Objects.equals(c.getIdVendedor(), id))
                .findFirst()
                .orElse(null);

        if(vendedor != null){
            return new ResponseEntity<>(vendedor, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Vendedor> modificarVendedor (Vendedor nuevoVendedor) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Vendedor> vendedores = cs.getSellers();
        Vendedor vendedor = vendedores.stream()
                .filter(c -> Objects.equals(c.getIdVendedor(), nuevoVendedor.getIdVendedor()))
                .findFirst()
                .orElse(null);

        if(vendedor != null){
            vendedor.setName(nuevoVendedor.getName());
            vendedor.setSurname(nuevoVendedor.getSurname());
            vendedor.setPassword(nuevoVendedor.getPassword());
            vendedor.setBirthDate(nuevoVendedor.getBirthDate());
            vendedor.setTipo_usuario(nuevoVendedor.getTipo_usuario());
            vendedor.setEmail(nuevoVendedor.getEmail());
            vendedor.setIdVendedor(nuevoVendedor.getIdVendedor());
            vendedor.setVentas(nuevoVendedor.getVentas());
            return new ResponseEntity<>(nuevoVendedor, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<ArrayList<Vendedor>> eliminarVendedor(long id) {

        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Vendedor> vendedores = cs.getSellers();

        Vendedor vendedor = vendedores.stream()
                .filter(v -> Objects.equals(v.getIdVendedor(), id))
                .findFirst()
                .orElse(null);

        if(vendedor != null){
            vendedores.remove(vendedor);
            cs.setSellers(vendedores);
            return new ResponseEntity<>(vendedores, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

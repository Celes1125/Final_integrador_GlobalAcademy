package com.example.demo.services;
import com.example.demo.CategoriasSingleton;
import com.example.demo.models.Vendedor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class VendedorService {
    public ResponseEntity<ArrayList<Vendedor>> crearVendedor(Vendedor nuevoVendedor) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Vendedor> vendedores = cs.getVendedores();

        Vendedor vendedor = vendedores.stream()
                .filter(v -> Objects.equals(v.getIdVendedor(), nuevoVendedor.getIdVendedor()))
                .findFirst()
                .orElse(null);

        if(vendedor == null){
            vendedores.add(nuevoVendedor);
            cs.setVendedores(vendedores);
            return new ResponseEntity<>(vendedores, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ArrayList<Vendedor>> listarVendedores() {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Vendedor> vendedores = cs.getVendedores();
        return new ResponseEntity<>(vendedores, HttpStatus.OK);
    }

    public ResponseEntity<Vendedor> verVendedorXId(long id) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Vendedor> vendedores = cs.getVendedores();
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
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Vendedor> vendedores = cs.getVendedores();
        Vendedor vendedor = vendedores.stream()
                .filter(c -> Objects.equals(c.getIdVendedor(), nuevoVendedor.getIdVendedor()))
                .findFirst()
                .orElse(null);

        if(vendedor != null){
            vendedor.setNombre(nuevoVendedor.getNombre());
            vendedor.setApellido(nuevoVendedor.getApellido());
            vendedor.setPassword(nuevoVendedor.getPassword());
            vendedor.setFecha_nacimiento(nuevoVendedor.getFecha_nacimiento());
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

        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Vendedor> vendedores = cs.getVendedores();

        Vendedor vendedor = vendedores.stream()
                .filter(v -> Objects.equals(v.getIdVendedor(), id))
                .findFirst()
                .orElse(null);

        if(vendedor != null){
            vendedores.remove(vendedor);
            cs.setVendedores(vendedores);
            return new ResponseEntity<>(vendedores, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

package com.example.demo.services;
import com.example.demo.models.Client;
import com.example.demo.models.saleDetail;
import com.example.demo.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class DetalleVentaService {
    public static ResponseEntity <ArrayList<saleDetail>> sumarAlCarrito(String password, String email, String idProducto, int cantidad) {
        Client client = Client.ChecarCliente(password, email);
        Product product = Product.CheckProduct(idProducto, cantidad);
        if(client !=null && product !=null){//ACÁ DESPUÉS VER DE USAR MEJOR UN SWITCH CASE U OTRA COSA PARA QUE DEVUELVA BIEN EL ERROR...
            saleDetail saleDetail = new saleDetail(product, cantidad);
            Client.SumarAlCarrito(saleDetail);

            return new ResponseEntity<>(client.getCarrito(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

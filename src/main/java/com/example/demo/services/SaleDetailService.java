package com.example.demo.services;
import com.example.demo.SingletonCategories;
import com.example.demo.models.Client;
import com.example.demo.models.SaleDetail;
import com.example.demo.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


@Service
public class SaleDetailService {
    public static ResponseEntity <ArrayList<SaleDetail>> addToCart (String password, String email, String productId, int quantity) {
        Client client = Client.CheckClient(password, email);
        Product product = Product.CheckProduct(productId, quantity);
        if(client !=null && product !=null){//ACÁ DESPUÉS VER DE USAR MEJOR UN SWITCH CASE U OTRA COSA PARA QUE DEVUELVA BIEN EL ERROR...
            SaleDetail saleDetail = new SaleDetail(client.getClientId(), product, quantity);


            return new ResponseEntity<>(client.getClientCart(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}

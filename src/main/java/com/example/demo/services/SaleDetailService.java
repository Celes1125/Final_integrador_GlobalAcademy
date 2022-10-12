package com.example.demo.services;
import com.example.demo.SingletonCategories;
import com.example.demo.models.Client;
import com.example.demo.models.SaleDetail;
import com.example.demo.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;


@Service
public class SaleDetailService {
    public static ResponseEntity <ArrayList<SaleDetail>> addToCart (String password, String email, String productId, int quantity) {
        Client client = Client.CheckClient(password, email);
        Product product = Product.CheckProduct(productId, quantity);
        if(client !=null && product !=null){//ACÁ DESPUÉS VER DE USAR MEJOR UN SWITCH CASE U OTRA COSA PARA QUE DEVUELVA BIEN EL ERROR...
            SaleDetail newDetail = new SaleDetail(client.getClientId(), product, quantity);
            SingletonCategories sc = SingletonCategories.getInstance();
            ArrayList <SaleDetail> details = sc.getDetails();
            details.add(newDetail);
            sc.setDetails(details);
            sc.getClients();

            return new ResponseEntity<>(client.getClientCart(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public static ResponseEntity<ArrayList<SaleDetail>> removeFromCart(String password, String email, String productId) {
        Client client = Client.CheckClient(password, email);
        SaleDetail detailToRemove = client.getClientCart().stream()
                .filter(saleDetail -> Objects.equals(saleDetail.getProduct().getProductId(), productId))
                .findFirst()
                //.allMatch(saleDetail ->saleDetail.getProduct().getProductId(), productId)
                .orElse(null);
        SingletonCategories sc = SingletonCategories.getInstance();
        ArrayList <SaleDetail> details = sc.getDetails();
        details.remove(detailToRemove);
        sc.setDetails(details);
        return new ResponseEntity<>(client.getClientCart(), HttpStatus.OK);

    }

    public static ResponseEntity<ArrayList<SaleDetail>> getClientCart(String password, String email) {
        Client client = Client.CheckClient(password, email);
        ArrayList <SaleDetail> cart = client.getClientCart();
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    public static ResponseEntity<ArrayList<SaleDetail>> clearCart(String password, String email) {
        Client client = Client.CheckClient(password, email);
        client.ClearCart(client);
        return new ResponseEntity<>(client.getClientCart(), HttpStatus.OK);
    }
}

package com.example.demo.services;
import com.example.demo.SingletonCategories;
import com.example.demo.models.Seller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Objects;

@Service
public class SellerService {
    public ResponseEntity<ArrayList<Seller>> createSeller(Seller newSeller) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Seller> sellers = cs.getSellers();

        Seller seller = sellers.stream()
                .filter(s -> Objects.equals(s.getSellerId(), newSeller.getSellerId()))
                .findFirst()
                .orElse(null);

        if(seller == null){
            sellers.add(newSeller);
            cs.setSellers(sellers);
            return new ResponseEntity<>(sellers, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ArrayList<Seller>> listSellers() {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Seller> sellers = cs.getSellers();
        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }

    public ResponseEntity<Seller> getSellerById(String id) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Seller> sellers = cs.getSellers();
        Seller seller = sellers.stream()
                .filter(s -> Objects.equals(s.getSellerId(), id))
                .findFirst()
                .orElse(null);

        if(seller != null){
            return new ResponseEntity<>(seller, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Seller> updateSeller(Seller newSeller) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Seller> sellers = cs.getSellers();
        Seller seller = sellers.stream()
                .filter(s -> Objects.equals(s.getSellerId(), newSeller.getSellerId()))
                .findFirst()
                .orElse(null);

        if(seller != null){
            seller.setName(newSeller.getName());
            seller.setSurname(newSeller.getSurname());
            seller.setPassword(newSeller.getPassword());
            seller.setBirthDate(newSeller.getBirthDate());
            seller.setUserType(newSeller.getUserType());
            seller.setEmail(newSeller.getEmail());
            seller.setSellerId(newSeller.getSellerId());
            return new ResponseEntity<>(newSeller, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<ArrayList<Seller>> deleteSeller(long id) {

        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Seller> sellers = cs.getSellers();

        Seller seller = sellers.stream()
                .filter(s -> Objects.equals(s.getSellerId(), id))
                .findFirst()
                .orElse(null);

        if(seller != null){
            sellers.remove(seller);
            cs.setSellers(sellers);
            return new ResponseEntity<>(sellers, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

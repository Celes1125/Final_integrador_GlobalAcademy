package com.example.demo.services;
import com.example.demo.SingletonCategories;
import com.example.demo.models.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Objects;
@Service
public class ClientService {
    public ResponseEntity<ArrayList<Client>> createClient(Client newClient) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Client> clients = cs.getClients();

        Client client = clients.stream()
                .filter(c -> Objects.equals(c.getClientId(), newClient.getClientId()))
                .findFirst()
                .orElse(null);

        if(client == null){
            clients.add(newClient);
            cs.setClients(clients);
            return new ResponseEntity<>(clients, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ArrayList<Client>> listCLients() {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Client> clients = cs.getClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    public ResponseEntity<Client> getClientById(String id) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Client> clients = cs.getClients();
        Client client = clients.stream()
                .filter(c -> Objects.equals(c.getClientId(), id))
                .findFirst()
                .orElse(null);

        if(client != null){
            return new ResponseEntity<>(client, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Client> updateClient(Client newClient) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Client> clients = cs.getClients();
        Client client = clients.stream()
                .filter(c -> Objects.equals(c.getClientId(), newClient.getClientId()))
                .findFirst()
                .orElse(null);

        if(client != null){
            client.setName(newClient.getName());
            client.setSurname(newClient.getSurname());
            client.setPassword(newClient.getPassword());
            client.setBirthDate(newClient.getBirthDate());
            client.setUserType(newClient.getUserType());
            client.setEmail(newClient.getEmail());
            return new ResponseEntity<>(newClient, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<ArrayList<Client>> deleteClient(String id) {

        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Client> clients = cs.getClients();

        Client client = clients.stream()
                .filter(c -> Objects.equals(c.getClientId(), id))
                .findFirst()
                .orElse(null);

        if(client != null){
            clients.remove(client);
            cs.setClients(clients);
            return new ResponseEntity<>(clients, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}



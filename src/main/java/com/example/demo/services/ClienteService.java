package com.example.demo.services;
import com.example.demo.SingletonCategories;
import com.example.demo.models.Client;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Objects;
@Service
public class ClienteService {
    public ResponseEntity<ArrayList<Client>> crearCliente(Client nuevoClient) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Client> clients = cs.getClientes();

        Client client = clients.stream()
                .filter(c -> Objects.equals(c.getClientId(), nuevoClient.getClientId()))
                .findFirst()
                .orElse(null);

        if(client == null){
            clients.add(nuevoClient);
            cs.setClientes(clients);
            return new ResponseEntity<>(clients, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ArrayList<Client>> listarClientes() {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Client> clients = cs.getClientes();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    public ResponseEntity<Client> verClienteXId(String id) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Client> clients = cs.getClientes();
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

    public ResponseEntity<Client> modificarCliente(Client nuevoClient) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Client> clients = cs.getClientes();
        Client client = clients.stream()
                .filter(c -> Objects.equals(c.getClientId(), nuevoClient.getClientId()))
                .findFirst()
                .orElse(null);

        if(client != null){
            client.setName(nuevoClient.getName());
            client.setSurname(nuevoClient.getSurname());
            client.setPassword(nuevoClient.getPassword());
            client.setBirthDate(nuevoClient.getBirthDate());
            client.setTipo_usuario(nuevoClient.getTipo_usuario());
            client.setEmail(nuevoClient.getEmail());
            return new ResponseEntity<>(nuevoClient, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<ArrayList<Client>> eliminarCliente(String id) {

        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<Client> clients = cs.getClientes();

        Client client = clients.stream()
                .filter(c -> Objects.equals(c.getClientId(), id))
                .findFirst()
                .orElse(null);

        if(client != null){
            clients.remove(client);
            cs.setClientes(clients);
            return new ResponseEntity<>(clients, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}



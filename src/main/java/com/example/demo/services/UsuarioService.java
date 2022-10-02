


package com.example.demo.services;

import com.example.demo.SingletonCategories;
import com.example.demo.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class UsuarioService {

    public ResponseEntity<ArrayList<User>> crearUsuario(User nuevoUser) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<User> users = cs.getUsers();

        User user = users.stream()
                .filter(u -> Objects.equals(u.getUserId(), nuevoUser.getUserId()))
                .findFirst()
                .orElse(null);

        if(user == null){
            users.add(nuevoUser);
            cs.setUsers(users);
            return new ResponseEntity<>(users, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ArrayList<User>> listarUsuarios() {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<User> users = cs.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    public ResponseEntity<User> verUsuarioXId(long id) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<User> users = cs.getUsers();
        User user = users.stream()
                .filter(u -> Objects.equals(u.getUserId(), id))
                .findFirst()
                .orElse(null);

        if(user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<User> modificarUsuario(User nuevoUser) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<User> users = cs.getUsers();
        User user = users.stream()
                .filter(u -> Objects.equals(u.getUserId(), nuevoUser.getUserId()))
                .findFirst()
                .orElse(null);

        if(user != null){
            user.setName(nuevoUser.getName());
            user.setSurname(nuevoUser.getSurname());
            user.setPassword(nuevoUser.getPassword());
            user.setBirthDate(nuevoUser.getBirthDate());
            user.setTipo_usuario(nuevoUser.getTipo_usuario());
            user.setEmail(nuevoUser.getEmail());
            return new ResponseEntity<>(user, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<ArrayList<User>> eliminarUsuario(long id) {

        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<User> users = cs.getUsers();

        User user = users.stream()
                .filter(u -> Objects.equals(u.getUserId(), id))
                .findFirst()
                .orElse(null);

        if(user != null){
            users.remove(user);
            cs.setUsers(users);
            return new ResponseEntity<>(users, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }








    }
}

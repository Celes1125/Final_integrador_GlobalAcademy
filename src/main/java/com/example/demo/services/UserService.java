


package com.example.demo.services;

import com.example.demo.SingletonCategories;
import com.example.demo.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class UserService {

    public ResponseEntity<ArrayList<User>> createUser(User newUser) {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<User> users = cs.getUsers();

        User user = users.stream()
                .filter(u -> Objects.equals(u.getUserId(), newUser.getUserId()))
                .findFirst()
                .orElse(null);

        if(user == null){
            users.add(newUser);
            cs.setUsers(users);
            return new ResponseEntity<>(users, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ArrayList<User>> listUsers() {
        SingletonCategories cs = SingletonCategories.getInstance();
        ArrayList<User> users = cs.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    public ResponseEntity<User> getUserById(long id) {
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

    public ResponseEntity<User> updateUser(User nuevoUser) {
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
            user.setUserType(nuevoUser.getUserType());
            user.setEmail(nuevoUser.getEmail());
            return new ResponseEntity<>(user, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<ArrayList<User>> deleteUser(String id) {

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

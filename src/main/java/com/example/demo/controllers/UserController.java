package com.example.demo.controllers;

import com.example.demo.services.UserService;
import com.example.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //CREAR USUARIO desde /users

    @PostMapping(
            value = "/users",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<User>> crearUsuario(
            @RequestBody User newUser

    ) {
        return userService.createUser(newUser);
    }

    //CONSULTAR LISTA DE USUARIOS desde /users
    @GetMapping(
            value = "/users",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<User>> listUsers() {
        return userService.listUsers();
    }

    //CONSULTAR UN USUARIO ESPECÍFICO desde /users/{id}
    @GetMapping(
            value = "/users/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<User> getUserById(
            @PathVariable(name = "id") long id
    ) {
        return userService.getUserById(id);
    }

    //MODIFICAR UN USUARIO desde /users/{id}

    @PutMapping(
            value = "/users",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<User> updateUser(
            @RequestBody User newUser
    ) {
        return userService.updateUser(newUser);

    }

    //BORRAR UN USUARIO ESPECÍFICO desde /users/{id}

    @DeleteMapping(
            value = "/users/{id}"

    )
    @ResponseBody
    public ResponseEntity<ArrayList<User>> deleteUser(
            @PathVariable(name = "id") String id
    ) {
        return userService.deleteUser(id);

    }

    //ver usuarios activos

     @GetMapping(
             value = "/login"
     )
    @ResponseBody
    public ResponseEntity<String>  login(
            @RequestHeader(value = "username") String username,
            @RequestHeader(value = "password") String password
     ){
        return userService.checkLogin(username,password);

     }
    //filtrar por cliente/vendedor/admin...
    //eliminación lógica del usuario
    //
}


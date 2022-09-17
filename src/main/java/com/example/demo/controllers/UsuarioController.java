package com.example.demo.controllers;

import com.example.demo.services.UsuarioService;
import com.example.demo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UsuarioController {

    @Autowired
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //CREAR USUARIO desde /usuarios

    @PostMapping(
            value = "/usuarios",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<Usuario>> crearUsuario(
            @RequestBody Usuario nuevoUsuario

    ) {
        return usuarioService.crearUsuario(nuevoUsuario);
    }

    //CONSULTAR LISTA DE USUARIOS desde /usuarios
    @GetMapping(
            value = "/usuarios",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<Usuario>> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    //CONSULTAR UN USUARIO ESPECÍFICO desde /usuarios/{id}
    @GetMapping(
            value = "/usuarios/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Usuario> verUsuarioXId(
            @PathVariable(name = "id") long id
    ) {
        return usuarioService.verUsuarioXId(id);
    }

    //MODIFICAR UN USUARIO desde /usuarios/{id}

    @PutMapping(
            value = "/usuarios",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Usuario> modificarUsuario(
            @RequestBody Usuario nuevoUsuario
    ) {
        return usuarioService.modificarUsuario(nuevoUsuario);

    }

    //BORRAR UN USUARIO ESPECÍFICO desde /usuarios/{id}

    @DeleteMapping(
            value = "/usuarios/{id}"

    )
    @ResponseBody
    public ResponseEntity<ArrayList<Usuario>> eliminarUsuario(
            @PathVariable(name = "id") long id
    ) {
        return usuarioService.eliminarUsuario(id);

    }
}


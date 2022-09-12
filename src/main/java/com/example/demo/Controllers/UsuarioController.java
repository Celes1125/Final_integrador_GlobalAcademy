package com.example.demo.Controllers;

import com.example.demo.Services.UsuarioService;
import com.example.demo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @PostMapping(
            value = "/usuarios",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<ArrayList<Usuario>> crearUsuario (
            @RequestBody Usuario usuario

    ) {
        return new ResponseEntity<>(usuarioService.crearUsuario(usuario), HttpStatus.CREATED);
    };

    @DeleteMapping (
            value = "/usuarios/{id}",
                    produces = MediaType.APPLICATION_JSON_VALUE
            )
    @ResponseBody
    public ResponseEntity<?> eliminarUsuario (
            @PathVariable (name = "id") int id
    ) {
        return usuarioService.eliminarUsuario(id);
    };




    @GetMapping(
            value = "/usuarios",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ArrayList<Usuario> listarUsuarios ( ) {
        return usuarioService.listarUsuarios();
    }

    @GetMapping (
            value = "/usuarios/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<?> verUsuarioXId (
            @PathVariable (name = "id") int id
    ) {
        return usuarioService.verUsuarioXId(id);
    }


}

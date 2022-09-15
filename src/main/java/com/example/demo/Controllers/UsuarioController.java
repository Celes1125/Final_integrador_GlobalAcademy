package com.example.demo.Controllers;

import com.example.demo.Services.UsuarioService;
import com.example.demo.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
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
            @RequestBody Usuario usuario

    ) {
        return new ResponseEntity<>(usuarioService.crearUsuario(usuario), HttpStatus.CREATED);
    }



    //CONSULTAR LISTA DE USUARIOS desde /usuarios
    @GetMapping(
            value = "/usuarios",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ArrayList<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    //CONSULTAR UN USUARIO ESPECÍFICO desde /usuarios/{id}
    @GetMapping(
            value = "/usuarios/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<?> verUsuarioXId(
            @PathVariable(name = "id") int id
    ) {
        return usuarioService.verUsuarioXId(id);
    }

    //MODIFICAR UN USUARIO desde /usuarios/{id}

    @PutMapping(
            value = "/usuarios/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public Usuario modificarUsuario(
            @PathVariable(name = "id") int id,
            @RequestBody Usuario usuario
    ) {
        usuarioService.modificarUsuario(id, usuario);
        return usuario;
    }

    //BORRAR UN USUARIO ESPECÍFICO desde /usuarios/{id}

    @DeleteMapping(
            value = "/usuarios/{id}"

    )
    @ResponseBody
    public ResponseEntity<ArrayList<Usuario>> eliminarUsuario(
            @PathVariable(name = "id") int id
    ) {
        return new ResponseEntity<>(usuarioService.eliminarUsuario(id), HttpStatus.OK);

    }
}

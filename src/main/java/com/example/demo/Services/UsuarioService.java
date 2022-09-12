package com.example.demo.Services;

import com.example.demo.CategoriasSingleton;
import com.example.demo.models.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioService {

    public ArrayList<Usuario> crearUsuario(Usuario usuario) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Usuario> usuarios = cs.getUsuarios();
        usuarios.add(usuario);
        cs.setUsuarios(usuarios);
        return usuarios;
    }

    public ArrayList<Usuario> listarUsuarios() {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Usuario> usuarios = cs.getUsuarios();
        return usuarios;
    }

    public ResponseEntity<?> verUsuarioXId(int id) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Usuario> usuarios = cs.getUsuarios();
        try {
            return new ResponseEntity<>(usuarios.get(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ArrayList<Usuario> modificarUsuario(Usuario usuario) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Usuario> usuarios = cs.getUsuarios();
        usuarios.stream().filter(usuario.getId()== usuario.getId());


        cs.setUsuarios(usuarios);
        return usuarios;


    }

}

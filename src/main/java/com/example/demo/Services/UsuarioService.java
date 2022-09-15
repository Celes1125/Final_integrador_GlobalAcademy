package com.example.demo.Services;

import com.example.demo.CategoriasSingleton;
import com.example.demo.models.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.stream.Collectors;

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


    public void modificarUsuario(int id, Usuario usuario) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Usuario> usuarios = cs.getUsuarios();
        usuarios.stream()
                .map(u -> {
                    if (u.getId() == id) {
                        u.setNombre(usuario.getNombre());
                        u.setApellido(usuario.getApellido());
                        u.setPassword(usuario.getPassword());
                        u.setFecha_nacimiento(usuario.getFecha_nacimiento());
                        u.setTipo_usuario(usuario.getTipo_usuario());
                        u.setEmail(usuario.getEmail());
                    }
                    return u;
                })
                .collect(Collectors.toList());
    }

    public ArrayList<Usuario> eliminarUsuario(int id) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Usuario> usuarios = cs.getUsuarios();
        usuarios.remove(id);
        cs.setUsuarios(usuarios);
        return usuarios;


    }
}
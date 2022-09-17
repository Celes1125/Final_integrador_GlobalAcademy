


package com.example.demo.services;

import com.example.demo.CategoriasSingleton;
import com.example.demo.models.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class UsuarioService {

    public ResponseEntity<ArrayList<Usuario>> crearUsuario(Usuario nuevoUsuario) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Usuario> usuarios = cs.getUsuarios();

        Usuario usuario = usuarios.stream()
                .filter(u -> Objects.equals(u.getIdUsuario(), nuevoUsuario.getIdUsuario()))
                .findFirst()
                .orElse(null);

        if(usuario == null){
            usuarios.add(nuevoUsuario);
            cs.setUsuarios(usuarios);
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<ArrayList<Usuario>> listarUsuarios() {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Usuario> usuarios = cs.getUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    public ResponseEntity<Usuario> verUsuarioXId(long id) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Usuario> usuarios = cs.getUsuarios();
        Usuario usuario = usuarios.stream()
                .filter(u -> Objects.equals(u.getIdUsuario(), id))
                .findFirst()
                .orElse(null);

        if(usuario != null){
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Usuario> modificarUsuario(Usuario nuevoUsuario) {
        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Usuario> usuarios = cs.getUsuarios();
        Usuario usuario = usuarios.stream()
                .filter(u -> Objects.equals(u.getIdUsuario(), nuevoUsuario.getIdUsuario()))
                .findFirst()
                .orElse(null);

        if(usuario != null){
            usuario.setNombre(nuevoUsuario.getNombre());
            usuario.setApellido(nuevoUsuario.getApellido());
            usuario.setPassword(nuevoUsuario.getPassword());
            usuario.setFecha_nacimiento(nuevoUsuario.getFecha_nacimiento());
            usuario.setTipo_usuario(nuevoUsuario.getTipo_usuario());
            usuario.setEmail(nuevoUsuario.getEmail());
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<ArrayList<Usuario>> eliminarUsuario(long id) {

        CategoriasSingleton cs = CategoriasSingleton.getInstance();
        ArrayList<Usuario> usuarios = cs.getUsuarios();

        Usuario usuario = usuarios.stream()
                .filter(u -> Objects.equals(u.getIdUsuario(), id))
                .findFirst()
                .orElse(null);

        if(usuario != null){
            usuarios.remove(usuario);
            cs.setUsuarios(usuarios);
            return new ResponseEntity<>(usuarios, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }








    }
}

package com.example.demo;

import com.example.demo.models.Usuario;

import java.util.ArrayList;

public class CategoriasSingleton {
    //atributos
    private static CategoriasSingleton INSTANCE;
    private ArrayList<Usuario> usuarios;

    //constructor vacío pero con el atributo array usuarios iniciado
    public CategoriasSingleton() {
        usuarios = new ArrayList<>();
    }

    //método con el if...si no está esto no va a funcionar!!! este código instancia a INSTANCE si aún no ha sido instanciada, sino, llama a la que ya fue creada.

    public static  CategoriasSingleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new CategoriasSingleton();
        }
        return INSTANCE;
    }

    public ArrayList<Usuario> getUsuarios(){
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}

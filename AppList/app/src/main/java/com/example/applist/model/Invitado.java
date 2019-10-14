package com.example.applist.model;

import java.io.Serializable;

public class Invitado implements Serializable {

    private String nombre;
    private String apellido;

    public Invitado(String nombre, String apellido){
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}

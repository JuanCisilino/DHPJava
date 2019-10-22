package com.example.appmuvi.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Famoso implements Serializable {

    @SerializedName("name")
    private String nombre;
    @SerializedName("popularity")
    private String nacimiento;
    private int imagenDeFamoso;

    public Famoso(String nombre, String nacimiento, int imagenDeFamoso){
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.imagenDeFamoso = imagenDeFamoso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getImagenDePelicula() {
        return imagenDeFamoso;
    }

    public void setImagenDePelicula(int imagenDeFamoso) {
        this.imagenDeFamoso = imagenDeFamoso;
    }
}

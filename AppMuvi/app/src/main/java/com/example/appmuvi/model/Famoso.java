package com.example.appmuvi.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Famoso implements Serializable {

    public static final String BASE_URL = "https://image.tmdb.org/t/p/original";

    @SerializedName("name")
    private String nombre;
    @SerializedName("popularity")
    private String nacimiento;
    @SerializedName("profile_path")
    private String imagenDeFamoso;

    public Famoso(String nombre, String nacimiento, String imagenDeFamoso){
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.imagenDeFamoso = imagenDeFamoso;
    }

    public String getNombre() {
        return nombre;
    }


    public String getNacimiento() {
        return nacimiento;
    }


    public String getImagenDePelicula() {
        return imagenDeFamoso;
    }

    public String generaURLImagen(){
        return BASE_URL + imagenDeFamoso;
    }
}

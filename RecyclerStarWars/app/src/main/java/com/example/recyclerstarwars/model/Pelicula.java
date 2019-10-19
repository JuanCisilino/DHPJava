package com.example.recyclerstarwars.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Pelicula implements Serializable {

    @SerializedName("title")
    private String titulo;
    @SerializedName("release_date")
    private String fechaEstreno;
    private String director;
    @SerializedName("opening_crawl")
    private String sinopsis;


    public Pelicula(String titulo, String fechaEstreno, String director, String sinopsis) {
        this.titulo = titulo;
        this.fechaEstreno = fechaEstreno;
        this.director = director;
        this.sinopsis = sinopsis;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFechaEstreno() {
        return fechaEstreno;
    }

    public String getDirector() {
        return director;
    }

    public String getSinopsis() {
        return sinopsis;
    }

}

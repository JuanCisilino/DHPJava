package com.example.appmuvi.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Pelicula implements Serializable {

    @SerializedName("title")
    private String titulo;
    private String director;
    @SerializedName("release_date")
    private String fechaDeEstreno;
    private String imagenurl;
    @SerializedName("overview")
    private String sinopsis;
    private int imagenDePelicula;

    public Pelicula(String titulo, String director, String fechaDeEstreno, int imagenDePelicula) {
        this.titulo = titulo;
        this.director = director;
        this.fechaDeEstreno = fechaDeEstreno;
        this.sinopsis = sinopsis;
        this.imagenDePelicula = imagenDePelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getFechaDeEstreno() {
        return fechaDeEstreno;
    }

    public void setFechaDeEstreno(String fechaDeEstreno) {
        this.fechaDeEstreno = fechaDeEstreno;
    }

    public String getImagenurl() {
        return imagenurl;
    }

    public void setImagenurl(String imagenurl) {
        this.imagenurl = imagenurl;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        sinopsis = sinopsis;
    }

    public int getImagenDePelicula() {
        return imagenDePelicula;
    }

    public void setImagenDePelicula(int imagenDePelicula) {
        this.imagenDePelicula = imagenDePelicula;
    }
}

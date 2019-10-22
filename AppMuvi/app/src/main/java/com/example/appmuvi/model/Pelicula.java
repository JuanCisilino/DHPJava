package com.example.appmuvi.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import javax.net.ssl.SSLContext;

public class Pelicula implements Serializable {

    public static final String BASE_URL = "https://image.tmdb.org/t/p/original";

    @SerializedName("title")
    private String titulo;
    private String director;
    @SerializedName("release_date")
    private String fechaDeEstreno;
    @SerializedName("backdrop_path")
    private String imagenurl;
    @SerializedName("overview")
    private String sinopsis;

    public Pelicula(String titulo, String director, String fechaDeEstreno) {
        this.titulo = titulo;
        this.director = director;
        this.fechaDeEstreno = fechaDeEstreno;
        this.sinopsis = sinopsis;
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


    public String generaURLImagen(){
        return BASE_URL + imagenurl;
    }
}

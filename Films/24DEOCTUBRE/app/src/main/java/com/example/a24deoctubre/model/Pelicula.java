package com.example.a24deoctubre.model;

import com.google.gson.annotations.SerializedName;

public class Pelicula implements Serializable {

    public static final String BASE_URL = "https://image.tmdb.org/t/p/original";

    @SerializedName("title")
    private String titulo;
    private Integer id;
    private String director;
    @SerializedName("release_date")
    private String fechaDeEstreno;
    @SerializedName("poster_path")
    private String imagenurl;
    @SerializedName("overview")
    private String sinopsis;

    public Pelicula(String titulo, Integer id, String director, String fechaDeEstreno, String imagenurl, String sinopsis) {
        this.titulo = titulo;
        this.id = id;
        this.director = director;
        this.fechaDeEstreno = fechaDeEstreno;
        this.imagenurl = imagenurl;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String generaURLImagen(){
        return BASE_URL + imagenurl;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pelicula pelicula = (Pelicula) o;
        return id.equals(pelicula.id);
    }

  /*  @Override
    public int hashCode() {
        return Objects.hash(id);
    }*/
}
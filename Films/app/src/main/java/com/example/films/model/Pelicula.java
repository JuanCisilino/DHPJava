package com.example.films.model;

public class Pelicula {

    private String titulo, fechaDeEstreno, sinopsis, director;


    public Pelicula(String titulo, String fechaDeEstreno, String director) {
        this.titulo = titulo;
        this.director = director;
        this.fechaDeEstreno = fechaDeEstreno;
        this.sinopsis = sinopsis;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getFechaDeEstreno() {
        return fechaDeEstreno;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public String getDirector() {
        return director;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFechaDeEstreno(String fechaDeEstreno) {
        this.fechaDeEstreno = fechaDeEstreno;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
}

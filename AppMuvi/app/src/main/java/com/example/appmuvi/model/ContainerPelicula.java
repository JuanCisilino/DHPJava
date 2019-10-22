package com.example.appmuvi.model;

import java.util.List;

public class ContainerPelicula {

    private List<Pelicula> results;
    private List<Famoso> resultado;

    public List<Pelicula> getResults() {
        return results;
    }

    public List<Famoso> getResultado() {
        return resultado;
    }

    public void setResults(List<Pelicula> results) {
        this.results = results;
    }
}

package com.example.films.controller;

import com.example.films.model.Pelicula;
import com.example.films.model.PeliculaDao;

import java.util.List;

public class PeliculaController {

    public List<Pelicula> traerPeliculas(){

        PeliculaDao peliculaDao = new PeliculaDao();

        return peliculaDao.traerPeliculas();
    }
}

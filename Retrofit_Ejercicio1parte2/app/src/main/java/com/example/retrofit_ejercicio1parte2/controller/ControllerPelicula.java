package com.example.retrofit_ejercicio1parte2.controller;

import com.example.retrofit_ejercicio1parte2.model.Pelicula;
import com.example.retrofit_ejercicio1parte2.model.PeliculaDao;
import com.example.retrofit_ejercicio1parte2.utils.ResultListener;

import java.util.List;

public class ControllerPelicula {

    public void traerPeliculas(final ResultListener<List<Pelicula>> listenerDeLaVista){
        PeliculaDao peliculaDao = new PeliculaDao();

        peliculaDao.traerPeliculas(new ResultListener<List<Pelicula>>() {
            @Override
            public void finish(List<Pelicula> result) {
                listenerDeLaVista.finish(result);
            }
        });
    }
}

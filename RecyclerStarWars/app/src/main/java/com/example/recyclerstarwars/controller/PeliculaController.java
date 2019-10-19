package com.example.recyclerstarwars.controller;

import com.example.recyclerstarwars.model.Pelicula;
import com.example.recyclerstarwars.model.PeliculaDao;
import com.example.recyclerstarwars.utils.ResultListener;

import java.util.List;

public class PeliculaController {

    //por ahora el controler es un simple pasamanos que le pise al dao y se lo pasa a la vista
    public void traerPeliculas(final ResultListener<List<Pelicula>> listenerDeLaVista){
        PeliculaDao peliculaDao = new PeliculaDao();

        peliculaDao.traerPeliculas(new ResultListener<List<Pelicula>>() {
            @Override
            public void finish(List<Pelicula> result) {
                listenerDeLaVista.finish(result);
            }
        });
    }

    public void traePeli(Integer numeroPelicula, final ResultListener<Pelicula> listenerDeLaVista) {
        PeliculaDao peliculaDao = new PeliculaDao();

        peliculaDao.traePeli(numeroPelicula, new ResultListener<Pelicula>() {
            @Override
            public void finish(Pelicula result) {
                listenerDeLaVista.finish(result);
            }

        });
    }
}

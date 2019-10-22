package com.example.appmuvi.controller;

import com.example.appmuvi.model.Famoso;
import com.example.appmuvi.model.FamososDAO;
import com.example.appmuvi.utils.ListenerPelicula;
import com.example.appmuvi.model.Pelicula;
import com.example.appmuvi.model.PeliculaDAO;

import java.util.List;

public class ControllerPelicula {

    //por ahora el controler es un simple pasamanos que le pise al dao y se lo pasa a la vista

    public void traePelicula(final ListenerPelicula<List<Pelicula>> listenerDeLaVista) {
        PeliculaDAO peliculaDao = new PeliculaDAO();

        peliculaDao.traerPeliculas(new ListenerPelicula<List<Pelicula>>() {
            @Override
            public void finish(List<Pelicula> result) {
                listenerDeLaVista.finish(result);
            }

        });
    }

  /*  public void traePeli(Integer numeroPelicula, final ListenerPelicula<Pelicula> listenerDeLaVista) {
        PeliculaDAO peliculaDao = new PeliculaDAO();

        peliculaDao.traePelicula(numeroPelicula, new ListenerPelicula<Pelicula>() {
            @Override
            public void finish(List<Famoso> result) {
                listenerDeLaVista.finish(result);
            }

        });
    }
*/
    public void traeFamoso(final ListenerPelicula<List<Famoso>> listenerDeLaVistaFamoso) {
        FamososDAO famososDAO = new FamososDAO();

        famososDAO.traerFamosos(new ListenerPelicula<List<Famoso>>() {
            @Override
            public void finish(List<Famoso> resultado) {
                   listenerDeLaVistaFamoso.finish(resultado);
            }

        });

    }
}



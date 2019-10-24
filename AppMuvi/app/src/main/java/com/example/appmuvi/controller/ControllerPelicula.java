package com.example.appmuvi.controller;

import com.example.appmuvi.model.Credits;
import com.example.appmuvi.model.Famoso;
import com.example.appmuvi.model.FamososDAO;
import com.example.appmuvi.model.Persona;
import com.example.appmuvi.utils.ResultListener;
import com.example.appmuvi.model.Pelicula;
import com.example.appmuvi.model.PeliculaDAO;

import java.util.List;

public class ControllerPelicula {

    //por ahora el controler es un simple pasamanos que le pise al dao y se lo pasa a la vista

    public void traePelicula(final ResultListener<List<Pelicula>> listenerDeLaVista) {
        final PeliculaDAO peliculaDao = new PeliculaDAO();

        peliculaDao.traerPeliculas(new ResultListener<List<Pelicula>>() {
            @Override
            public void finish(final List<Pelicula> resultPelicula) {
                for (Pelicula pelicula : resultPelicula) {
                    Integer movieId = pelicula.getId();
                    peliculaDao.traerCredits(new ResultListener<Credits>() {
                        @Override
                        public void finish(Credits resultCredit) {
                            if(resultCredit != null){
                            Integer id = resultCredit.getId();
                            String directorName = resultCredit.getCrew().get(0).getName(); //Nombre del director (supuestamente)
                            for (Pelicula pelicula1 : resultPelicula) {
                                if(pelicula1.getId().equals(id)) {
                                    pelicula1.setDirector(directorName);
                                }
                                    listenerDeLaVista.finish(resultPelicula);
                                }
                            }
                        }
                    }, movieId);
                }

                //listenerDeLaVista.finish(result);
            }

        });
    }

  /*  public void traePeli(Integer numeroPelicula, final ResultListener<Pelicula> listenerDeLaVista) {
        PeliculaDAO peliculaDao = new PeliculaDAO();

        peliculaDao.traePelicula(numeroPelicula, new ResultListener<Pelicula>() {
            @Override
            public void finish(List<Famoso> result) {
                listenerDeLaVista.finish(result);
            }

        });
    }
*/
    public void traeFamoso(final ResultListener<List<Famoso>> listenerDeLaVistaFamoso) {
        final FamososDAO famososDAO = new FamososDAO();

        famososDAO.traerFamosos(new ResultListener<List<Famoso>>() {
            @Override
            public void finish(final List<Famoso> resultado) {
                for (final Famoso famoso : resultado) {
                    Integer id = famoso.getId();
                    famososDAO.traerPersona(new ResultListener<Credits>() {
                        @Override
                        public void finish(Credits result) {
                            if(result != null){
                                String cumple = result.getBirthday();
                                famoso.setNacimiento(cumple);
                            }
                            listenerDeLaVistaFamoso.finish(resultado);
                        }
                    }, id);
                }

            }

        });

    }
}



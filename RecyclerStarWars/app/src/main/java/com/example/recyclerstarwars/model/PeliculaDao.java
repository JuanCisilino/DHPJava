package com.example.recyclerstarwars.model;

import android.util.Log;

import com.example.recyclerstarwars.utils.ResultListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeliculaDao extends PeliculasRetrofitDAO{

    private static final String BASE_URL = "https://swapi.co";

    public PeliculaDao() {
        super(BASE_URL);
    }

    //hice el harcodeo de las peliculas
    public void traerPeliculas(final ResultListener<List<Pelicula>> listenerDelControler){

        Call<ContainerPelicula> call = peliculasService.traerPeliculas();

        call.enqueue(new Callback<ContainerPelicula>() {
            @Override
            public void onResponse(Call<ContainerPelicula> call, Response<ContainerPelicula> response) {
                ContainerPelicula containerPelicula = response.body();
                listenerDelControler.finish(containerPelicula.getResults());
            }

            @Override
            public void onFailure(Call<ContainerPelicula> call, Throwable t) {


            }
        });

    }

    public void traePeli(Integer numeroPelicula, final ResultListener<Pelicula> listenerDelControler) {
        Call<Pelicula> call = peliculasService.traePelicula(numeroPelicula);

        call.enqueue(new Callback<Pelicula>() {
            @Override
            public void onResponse(Call<Pelicula> call, Response<Pelicula> response) {
                Pelicula pelicula = response.body();
                listenerDelControler.finish(pelicula);
            }

            @Override
            public void onFailure(Call<Pelicula> call, Throwable t) {

            }
        });
    }

}

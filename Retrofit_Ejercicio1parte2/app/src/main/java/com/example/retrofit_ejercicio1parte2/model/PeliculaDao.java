package com.example.retrofit_ejercicio1parte2.model;

import com.example.retrofit_ejercicio1parte2.utils.ResultListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeliculaDao extends RetrofitPeliculasDao{

    public static final String BASE_URL = "https://api.myjson.com/bins/";

    public PeliculaDao() {
        super(BASE_URL);
    }

    public void traerPeliculas(final ResultListener<List<Pelicula>> listenerDelControler){

        Call<ContenedorPelicula> call = peliculasService.traerPeliculas();

        call.enqueue(new Callback<ContenedorPelicula>() {
            @Override
            public void onResponse(Call<ContenedorPelicula> call, Response<ContenedorPelicula> response) {
                ContenedorPelicula containerPelicula = response.body();
                listenerDelControler.finish(containerPelicula.getResults());
            }

            @Override
            public void onFailure(Call<ContenedorPelicula> call, Throwable t) {


            }
        });

    }

}

package com.example.appmuvi.model;

import android.util.Log;

import com.example.appmuvi.utils.ListenerPelicula;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeliculaDAO extends PeliculaRetrofitDAO{

    private static final String BASE_URL = "https://api.themoviedb.org";

    public PeliculaDAO() {
        super(BASE_URL);
    }

    public void traerPeliculas(final ListenerPelicula<List<Pelicula>> listenerDelControler){

        Call<ContainerPelicula> call = peliculasService.traerPelicula();

        call.enqueue(new Callback<ContainerPelicula>() {
            @Override
            public void onResponse(Call<ContainerPelicula> call, Response<ContainerPelicula> response) {
                ContainerPelicula containerPelicula = response.body();
                listenerDelControler.finish(containerPelicula.getResults());
            }

            @Override
            public void onFailure(Call<ContainerPelicula> call, Throwable t) {
                Log.d("ewfwq","dwsfaw");

            }
        });

    }

    /*public void traerPelicula(String categoria, final ListenerPelicula<Pelicula> listenerDelControler) {
        Call<Pelicula> call = peliculasService.traerPeliPorCategoria(categoria);

        call.enqueue(new Callback<Pelicula>() {
            @Override
            public void onResponse(Call<Pelicula> call, Response<Pelicula> response) {
                Pelicula unapelicula = response.body();
                listenerDelControler.finish(unapelicula response);
            }

            @Override
            public void onFailure(Call<Pelicula> call, Throwable t) {

            }
        });
    }
*/

}

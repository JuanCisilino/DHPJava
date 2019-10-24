package com.example.a24deoctubre.model;

import android.util.Log;

import com.example.a24deoctubre.utils.ResultListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeliculaDao extends PeliculaRetrofitDAO{

    private static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String API_KEY = "41c70e6b99d8ae34c17c9c34fd81e344";

    public PeliculaDAO() {
        super(BASE_URL);
    }

    public void traerPeliculas(final ResultListener<List<Pelicula>> listenerDelControler){

        Call<ContainerPelicula> call = peliculasService.traerPelicula(API_KEY);

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

    public  void traerCredits(final ResultListener<Credits> resultListenerController,Integer movieId){
        Call<Credits> creditsCall = peliculasService.traerCredits(movieId,API_KEY);

        creditsCall.enqueue(new Callback<Credits>() {
            @Override
            public void onResponse(Call<Credits> call, Response<Credits> response) {
                Credits resultsCredit = response.body();
                resultListenerController.finish(resultsCredit);
            }

            @Override
            public void onFailure(Call<Credits> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    /*public void traerPelicula(String categoria, final ResultListener<Pelicula> listenerDelControler) {
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


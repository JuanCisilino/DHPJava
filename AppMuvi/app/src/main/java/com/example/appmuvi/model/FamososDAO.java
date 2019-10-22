package com.example.appmuvi.model;

import android.util.Log;

import com.example.appmuvi.utils.ListenerPelicula;
import com.example.appmuvi.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FamososDAO extends PeliculaRetrofitDAO{

    private static final String BASE_URL = "https://api.themoviedb.org";

    public FamososDAO() {
        super(BASE_URL);
    }

    public void traerFamosos(final ListenerPelicula<List<Famoso>> listenerDelControler){

        Call<ContainerPelicula> call = peliculasService.traerFamoso();

        call.enqueue(new Callback<ContainerPelicula>() {
            @Override
            public void onResponse(Call<ContainerPelicula> call, Response<ContainerPelicula> response) {
                ContainerPelicula containerPelicula = response.body();
                listenerDelControler.finish(containerPelicula.getResultado());
            }

            @Override
            public void onFailure(Call<ContainerPelicula> call, Throwable t) {
                Log.d("ewfwq","dwsfaw");

            }
        });

    }

   /* public void traerFamoso(ListenerPelicula<List<Famoso>> listListenerPelicula) {

        famosoList.add(new Famoso("Brad Pit","18/4/75", R.drawable.logomuviapp));
        famosoList.add(new Famoso("Brad Pit","18/4/75",R.drawable.logomuviapp));
        famosoList.add(new Famoso("Brad Pit","18/4/75",R.drawable.logomuviapp));
        famosoList.add(new Famoso("Brad Pit","18/4/75",R.drawable.logomuviapp));
        famosoList.add(new Famoso("Brad Pit","18/4/75",R.drawable.logomuviapp));
        famosoList.add(new Famoso("Brad Pit","18/4/75",R.drawable.logomuviapp));
        famosoList.add(new Famoso("Brad Pit","18/4/75",R.drawable.logomuviapp));
        famosoList.add(new Famoso("Brad Pit","18/4/75",R.drawable.logomuviapp));
        famosoList.add(new Famoso("Brad Pit","18/4/75",R.drawable.logomuviapp));
        famosoList.add(new Famoso("Brad Pit","18/4/75",R.drawable.logomuviapp));


        listListenerPelicula.finish(famosoList);


    }*/
}

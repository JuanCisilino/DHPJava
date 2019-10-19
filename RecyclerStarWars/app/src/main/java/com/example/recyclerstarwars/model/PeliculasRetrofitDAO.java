package com.example.recyclerstarwars.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PeliculasRetrofitDAO {

    private Retrofit retrofit;
    protected PeliculasService peliculasService;

    public PeliculasRetrofitDAO(String baseURL) {


        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        peliculasService = retrofit.create(PeliculasService.class);

    }
}

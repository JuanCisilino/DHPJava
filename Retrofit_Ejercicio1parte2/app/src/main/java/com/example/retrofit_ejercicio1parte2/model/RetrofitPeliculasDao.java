package com.example.retrofit_ejercicio1parte2.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitPeliculasDao {

    private Retrofit retrofit;
    protected PeliculaService peliculasService;

    public RetrofitPeliculasDao(String baseURL) {


        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        peliculasService = retrofit.create(PeliculaService.class);

    }
}

package com.example.retrofit_ejercicio2.model;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitProductosDao {

    private Retrofit retrofit;
    protected ServiceProducto serviceProducto;

    public RetrofitProductosDao(String baseURL) {


        retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        serviceProducto = retrofit.create(ServiceProducto.class);

    }

}

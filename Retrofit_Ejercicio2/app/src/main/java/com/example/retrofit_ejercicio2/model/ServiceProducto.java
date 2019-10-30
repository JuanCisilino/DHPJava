package com.example.retrofit_ejercicio2.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceProducto {

    @GET("search")
    Call<ContenedorProducto> traeListadePoducto(@Query("q") String nombreProducto);
}

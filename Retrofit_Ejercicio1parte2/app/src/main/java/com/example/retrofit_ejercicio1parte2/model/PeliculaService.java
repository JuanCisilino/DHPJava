package com.example.retrofit_ejercicio1parte2.model;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PeliculaService {

    @GET("4sblo")
    Call<ContenedorPelicula> traerPeliculas();


}

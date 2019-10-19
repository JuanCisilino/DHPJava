package com.example.recyclerstarwars.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PeliculasService {

    @GET("/api/films")
    Call<ContainerPelicula> traerPeliculas();

    @GET("/api/films/{id}")
    Call<Pelicula> traePelicula(@Path("id") int numeroPelicula);


}

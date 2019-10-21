package com.example.appmuvi.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceInterface {

    @GET("/3/movie")
    Call<ContainerPelicula> traerPelicula();

    @GET("/3/movie/{category}")
    Call<Pelicula> traerPeliPorCategoria(@Path("category") String categoria);


}

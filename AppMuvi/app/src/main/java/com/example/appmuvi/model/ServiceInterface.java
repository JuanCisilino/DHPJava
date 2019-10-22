package com.example.appmuvi.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceInterface {

    @GET("/3/movie/popular?api_key=41c70e6b99d8ae34c17c9c34fd81e344&language=en-US&page=1")
    Call<ContainerPelicula> traerPelicula();

    @GET("/3/person/popular?api_key=41c70e6b99d8ae34c17c9c34fd81e344&language=en-US&page=1")
    Call<ContainerPelicula> traerFamoso();

}

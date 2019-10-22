package com.example.appmuvi.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceInterface {

    @GET("/3/movie/popular")
    Call<ContainerPelicula> traerPelicula(@Query("api_key") String apiKey);

    @GET("/3/person/popular")
    Call<ContainerFamoso> traerFamoso(@Query("api_key") String apiKey);

}

package com.example.appmuvi.model;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceInterface {

    @GET("movie/popular")
    Call<ContainerPelicula> traerPelicula(@Query("api_key") String apiKey);

    @GET("movie/{movie_id}/credits")
    Call<Credits> traerCredits(@Path("movie_id") Integer movieId,@Query("api_key") String apiKey);

    @GET("person/popular")
    Call<ContainerFamoso> traerFamoso(@Query("api_key") String apiKey);

    @GET("person/{person_id}")
    Call<Credits> traerPersona(@Path("person_id") Integer personId,@Query("api_key") String apiKey);



}

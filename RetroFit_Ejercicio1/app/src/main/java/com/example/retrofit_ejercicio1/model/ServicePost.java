package com.example.retrofit_ejercicio1.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicePost {

    @GET("1k5i4")
    Call<List<Post>> traerPosts();
}

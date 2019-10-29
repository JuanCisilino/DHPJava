package com.example.retrofit_ejercicio1parte2.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Pelicula implements Serializable {


    private String title;
    @SerializedName("year")
    private Integer estreno;

    public String getTitle() {
        return title;
    }

    public Integer getEstreno() {
        return estreno;
    }
}

package com.example.retrofit_ejercicio2.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Producto implements Serializable {


    private String title;
    private Integer price;
    @SerializedName("thumbnail")
    private String foto;

    public Producto(String title, Integer price, String foto) {
        this.title = title;
        this.price = price;
        this.foto = foto;
    }

    public Producto(){
        this.title = title;
        this.price = price;
        this.foto = foto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}

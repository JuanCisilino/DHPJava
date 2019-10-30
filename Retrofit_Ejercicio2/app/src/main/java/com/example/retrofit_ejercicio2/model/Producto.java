package com.example.retrofit_ejercicio2.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import static com.example.retrofit_ejercicio2.model.ProductosDao.BASE_URL;

public class Producto implements Serializable {


    private String title;
    private String price;
    private String thumbnail;

    public Producto(String title, String price, String thumbnail) {
        this.title = title;
        this.price = price;
        this.thumbnail = thumbnail;
    }

    public Producto(){
        this.title = title;
        this.price = price;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}

package com.example.appmuvi.utils;

import com.example.appmuvi.model.Pelicula;

import java.util.List;

public interface ResultListener<T> {

    public void finish(T result);

}

package com.example.retrofit_ejercicio2.controller;

import com.example.retrofit_ejercicio2.model.Producto;
import com.example.retrofit_ejercicio2.model.ProductosDao;
import com.example.retrofit_ejercicio2.utils.ResultListener;

import java.util.List;

public class ControlerProducto {

    private String consulta;

    public void traerProductos(String consulta, final ResultListener<List<Producto>> listenerDeLaVista) {
        ProductosDao productosDao = new ProductosDao();

        productosDao.traerPruductos(consulta, new ResultListener<List<Producto>>() {
            @Override
            public void finish(List<Producto> result) {
                listenerDeLaVista.finish(result);
            }
        });
    }
}

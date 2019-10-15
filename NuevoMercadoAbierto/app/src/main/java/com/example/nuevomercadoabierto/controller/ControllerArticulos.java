package com.example.nuevomercadoabierto.controller;

import android.os.Bundle;

import com.example.nuevomercadoabierto.ListenerArticulo;
import com.example.nuevomercadoabierto.R;
import com.example.nuevomercadoabierto.model.Articulo;
import com.example.nuevomercadoabierto.model.ArticulosDAO;

import java.util.List;

public class ControllerArticulos {

    //por ahora el controler es un simple pasamanos que le pise al dao y se lo pasa a la vista
    public void traerArticulos(final ListenerArticulo listenerDeLaVista){
        ArticulosDAO articulosDAO = new ArticulosDAO();

        articulosDAO.traerArticulos(new ListenerArticulo<List<Articulo>>() {
            @Override
            public void finish(List<Articulo> result) {
                listenerDeLaVista.finish(result);
            }
        });
    }




   /* public void agregarArticulo(final ListenerArticulo listenerDelBotonAgregar){
        Articulo articuloAAgregar = new Articulo(articulo.getNombreDeArticulo(),articulo.getPrecioDeArticulo(),articulo.getDescripcionDeArticulo(), R.drawable.ic_launcher_foreground);
        ArticulosDAO articulosDAO = new ArticulosDAO();
       return articulosDAO.agregarArticulo(articulo);
    }*/
}

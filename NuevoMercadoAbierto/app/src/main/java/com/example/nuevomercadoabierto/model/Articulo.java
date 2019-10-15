package com.example.nuevomercadoabierto.model;

import java.io.Serializable;

public class Articulo implements Serializable {

    private String nombreDeArticulo;
    private String descripcionDeArticulo;
    private String precioDeArticulo;
    private int imagenDeArticulo;

    public Articulo(String nombreDeArticulo, String precioDeArticulo , String descripcionDeArticulo, int imagenDeArticulo) {
        this.imagenDeArticulo = imagenDeArticulo;
        this.nombreDeArticulo = nombreDeArticulo;
        this.descripcionDeArticulo = descripcionDeArticulo;
        this.precioDeArticulo = precioDeArticulo;
    }

    public int getImagenDeArticulo() {
        return imagenDeArticulo;
    }

    public String getNombreDeArticulo() {
        return nombreDeArticulo;
    }

    public String getDescripcionDeArticulo() {
        return descripcionDeArticulo;
    }

    public String getPrecioDeArticulo() {
        return precioDeArticulo;
    }


}

package com.example.nuevomercadoabierto.model;

import android.content.Intent;
import android.os.Bundle;

import com.example.nuevomercadoabierto.ListenerArticulo;
import com.example.nuevomercadoabierto.R;
import com.example.nuevomercadoabierto.view.AdapterArticulo;
import com.example.nuevomercadoabierto.view.FragmentAgregarArticulo;
import com.example.nuevomercadoabierto.view.FragmentListaDeArticulos;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class ArticulosDAO  {

    public static final String NOMBRE = "Nombre", PRECIO = "Precio", DESCRIPCION = "Descripcion";

    List<Articulo> articuloList = new ArrayList<>();

    public void traerArticulos(ListenerArticulo<List<Articulo>> listenerArticulo){


        articuloList.add(
                new Articulo("Amoladora", "$500",
                        "Amoladora de 112mm, perfecta para trabajos de hobbie o profesionales.",
                        R.drawable.ic_launcher_background));

        articuloList.add(
                new Articulo("Taladro", "$350",
                        "Taladro con mandril de 13mm, perfecta para trabajos de hobbie o profesionales.",
                        R.drawable.ic_launcher_background));

        articuloList.add(
                new Articulo("Remachadora", "$400",
                        "Remachadora con bocas de hasta 5mm, perfecta para trabajos de hobbie o profesionales.",
                        R.drawable.ic_launcher_background));

        articuloList.add(
                new Articulo("Dildo", "$1500",
                        "Ideal para el bolsillo de la dama y el morral del caballero.",
                        R.drawable.ic_launcher_background));

        articuloList.add(
                new Articulo("Amoladora", "$500",
                        "Amoladora de 112mm, perfecta para trabajos de hobbie o profesionales.",
                        R.drawable.ic_launcher_background));

        articuloList.add(
                new Articulo("Taladro", "$350",
                        "Taladro con mandril de 13mm, perfecta para trabajos de hobbie o profesionales.",
                        R.drawable.ic_launcher_background));

        articuloList.add(
                new Articulo("Remachadora", "$400",
                        "Remachadora con bocas de hasta 5mm, perfecta para trabajos de hobbie o profesionales.",
                        R.drawable.ic_launcher_background));

        articuloList.add(
                new Articulo("Dildo", "$1500",
                        "Ideal para el bolsillo de la dama y el morral del caballero.",
                        R.drawable.ic_launcher_background));

        articuloList.add(
                new Articulo("Amoladora", "$500",
                        "Amoladora de 112mm, perfecta para trabajos de hobbie o profesionales.",
                        R.drawable.ic_launcher_background));

        articuloList.add(
                new Articulo("Taladro", "$350",
                        "Taladro con mandril de 13mm, perfecta para trabajos de hobbie o profesionales.",
                        R.drawable.ic_launcher_background));

        articuloList.add(
                new Articulo("Remachadora", "$400",
                        "Remachadora con bocas de hasta 5mm, perfecta para trabajos de hobbie o profesionales.",
                        R.drawable.ic_launcher_background));

        articuloList.add(
                new Articulo("Dildo", "$1500",
                        "Ideal para el bolsillo de la dama y el morral del caballero.",
                        R.drawable.ic_launcher_background));


        listenerArticulo.finish(articuloList);

    }


}

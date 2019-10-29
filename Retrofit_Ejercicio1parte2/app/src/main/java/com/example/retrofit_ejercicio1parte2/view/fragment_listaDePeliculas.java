package com.example.retrofit_ejercicio1parte2.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.retrofit_ejercicio1parte2.R;
import com.example.retrofit_ejercicio1parte2.controller.ControllerPelicula;
import com.example.retrofit_ejercicio1parte2.model.Pelicula;
import com.example.retrofit_ejercicio1parte2.utils.ResultListener;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragment_listaDePeliculas extends Fragment implements AdapterPeliculas.ListenerDelAdapter{

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_de_peliculas, container, false);

        recyclerView = view.findViewById(R.id.fragmentPeliculas_recycler);

        final AdapterPeliculas adapterPeliculas = new AdapterPeliculas(this);

        ControllerPelicula controllerPelicula = new ControllerPelicula();

        controllerPelicula.traerPeliculas(new ResultListener<List<Pelicula>>() {
            @Override
            public void finish(List<Pelicula> result) {
                adapterPeliculas.setPeliculaList(result);
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        //setearle el adapter
        recyclerView.setAdapter(adapterPeliculas);

        return view;

    }

    @Override
    public void informarPelicula(Pelicula pelicula) {

    }
}

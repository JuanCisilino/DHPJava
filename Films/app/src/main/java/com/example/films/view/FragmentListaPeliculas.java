package com.example.films.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.films.R;
import com.example.films.controller.PeliculaController;
import com.example.films.model.Pelicula;
import com.example.films.model.PeliculaDao;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListaPeliculas extends Fragment {

    private RecyclerView recyclerView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_peliculas, container, false);

        recyclerView = view.findViewById(R.id.fragment_Peliculas_recycler);

        PeliculaController peliculaController = new PeliculaController();

        List<Pelicula> peliculasDeLaLista = peliculaController.traerPeliculas();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        AdapterPeliculas adapter = new AdapterPeliculas(peliculasDeLaLista);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(linearLayoutManager);


        return view;
    }



}

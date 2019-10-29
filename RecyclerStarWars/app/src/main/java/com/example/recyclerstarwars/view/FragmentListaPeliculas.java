package com.example.recyclerstarwars.view;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerstarwars.R;
import com.example.recyclerstarwars.controller.PeliculaController;
import com.example.recyclerstarwars.model.Pelicula;
import com.example.recyclerstarwars.utils.ResultListener;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListaPeliculas extends Fragment implements AdapterPeliculas.ListenerDelAdapter {


    private RecyclerView recyclerView;

    private ListenerDeFragment listenerDelFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_peliculas, container, false);

        //encontrar el recycler
        recyclerView = view.findViewById(R.id.fragmentPeliculas_recycler);
        //crear el adapter
        final AdapterPeliculas adapterPeliculas = new AdapterPeliculas(this);

        PeliculaController peliculaController = new PeliculaController();
        peliculaController.traerPeliculas(new ResultListener<List<Pelicula>>() {
            @Override
            public void finish(List<Pelicula> result) {
                adapterPeliculas.setPeliculaList(result);
            }
        });

        //setearle el layout manager (
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        //setearle el adapter
        recyclerView.setAdapter(adapterPeliculas);

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listenerDelFragment = (ListenerDeFragment) context;
    }

    @Override
    public void informarPelicula(Pelicula pelicula) {
        listenerDelFragment.recibirPelicula(pelicula);
    }

    public interface ListenerDeFragment {

        public void recibirPelicula(Pelicula pelicula);


    }

}

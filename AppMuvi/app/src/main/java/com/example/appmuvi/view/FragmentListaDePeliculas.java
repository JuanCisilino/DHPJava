package com.example.appmuvi.view;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appmuvi.utils.ListenerPelicula;
import com.example.appmuvi.R;
import com.example.appmuvi.controller.ControllerPelicula;
import com.example.appmuvi.model.Pelicula;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListaDePeliculas extends Fragment implements AdapterPeliculas.ListenerDelAdapter{

    private RecyclerView recyclerView;

    private ListenerDeFragment listenerDelFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lista_de_peliculas, container, false);
        // Inflate the layout for this fragment
        //encontrar el recycler
        recyclerView = view.findViewById(R.id.fragmentPeliculas_recycler);
        //crear el adapter
        final AdapterPeliculas adapterPeliculas = new AdapterPeliculas(this);

        ControllerPelicula peliculaController = new ControllerPelicula();
        peliculaController.traePelicula(new ListenerPelicula<List<Pelicula>>() {
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

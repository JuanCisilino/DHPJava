package com.example.recyclerstarwars.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerstarwars.R;
import com.example.recyclerstarwars.model.Pelicula;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_DetallePelicula extends Fragment {

    public static final String CLAVE_PELICULA = "Pelicula";

    private TextView textViewTitulo, textViewSinopsis;


    public Fragment_DetallePelicula() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment__detalle_pelicula, container, false);

        textViewTitulo = view.findViewById(R.id.fragment_detalle_TituloPelicula);
        textViewSinopsis = view.findViewById(R.id.fragment_detalle_DescripcionPelicula);

        Pelicula peliculaSeleccionada = (Pelicula) getArguments().getSerializable(CLAVE_PELICULA);

        textViewTitulo.setText(peliculaSeleccionada.getTitulo());
        textViewSinopsis.setText(peliculaSeleccionada.getSinopsis());

        return view;
    }

}

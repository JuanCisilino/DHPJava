package com.example.nuevomercadoabierto.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nuevomercadoabierto.R;
import com.example.nuevomercadoabierto.model.Articulo;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDescripcionDelArticulo extends Fragment {

    public static final String CLAVE_ARTICULO = "claveArticulo";

    private TextView textViewTitulo, textViewPrecio, textViewdescripcion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_descripcion_del_articulo, container, false);

        textViewTitulo = view.findViewById(R.id.fragment_descripcion_textview_nombre_articulo);
        textViewPrecio = view.findViewById(R.id.fragment_descripcion_textView_precio_articulo);
        textViewdescripcion = view.findViewById(R.id.fragment_descripcion_textview_descripcion_articulo);

        Bundle bundle = getArguments();
        Articulo articuloSeleccionada =  (Articulo) bundle.getSerializable(CLAVE_ARTICULO);

        textViewTitulo.setText(articuloSeleccionada.getNombreDeArticulo());
        textViewPrecio.setText(articuloSeleccionada.getPrecioDeArticulo());
        textViewdescripcion.setText(articuloSeleccionada.getDescripcionDeArticulo());

        return view;
    }

}

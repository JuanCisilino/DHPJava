package com.example.nuevomercadoabierto.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.nuevomercadoabierto.R;
import com.example.nuevomercadoabierto.model.Articulo;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAgregarArticulo extends Fragment implements Serializable {


    private EditText nombreArticulo, precio, descripcion;
    private Button botonAgregar;
    private ListenerDeFragment listener;

    public FragmentAgregarArticulo(ListenerDeFragment listener) {
        // Required empty public constructor
        this.listener = listener;
    }

    public FragmentAgregarArticulo() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_agregar_articulo, container, false);

        nombreArticulo = view.findViewById(R.id.fragment_AgregarArticulo_editText_nombre_articulo);
        precio = view.findViewById(R.id.fragment_AgregarArticulo_editText_precio_articulo);
        descripcion = view.findViewById(R.id.fragment_AgregarArticulo_editText_descripcion_articulo);
        botonAgregar = view.findViewById(R.id.fragment_AgregarArticulo_botonAgregar);

        botonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = nombreArticulo.getText().toString();
                String costo = precio.getText().toString();
                String description = descripcion.getText().toString();

                Articulo articulo = new Articulo(nombre,costo,description,R.drawable.ic_launcher_foreground);
                listener.agregarArticuloALista(articulo);
            }
        });


        return view;
    }

    public interface ListenerDeFragment{
        public void agregarArticuloALista(Articulo articulo);
    }

}

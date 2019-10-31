package com.example.nuevomercadoabierto.view;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.nuevomercadoabierto.R;
import com.example.nuevomercadoabierto.model.Articulo;
import com.example.nuevomercadoabierto.model.ArticulosDAO;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAgregarArticulo extends Fragment {


    private EditText nombreArticulo, precio, descripcion;
    private Button botonAgregar;
    private ListerDeAgregarArticulo listerDeAgregarArticulo;


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

                listerDeAgregarArticulo.agregararticulo(articulo);
            }
        });


        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listerDeAgregarArticulo = (ListerDeAgregarArticulo) context;
    }

    public interface ListerDeAgregarArticulo{
        public void agregararticulo(Articulo articulo);
    }




}

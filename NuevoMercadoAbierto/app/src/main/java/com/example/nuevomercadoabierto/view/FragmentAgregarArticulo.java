package com.example.nuevomercadoabierto.view;


import android.content.Intent;
import android.os.Bundle;

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
public class FragmentAgregarArticulo extends Fragment implements FragmentListaDeArticulos.ListenerDeFragment {


    private EditText nombreArticulo, precio, descripcion;
    private FragmentListaDeArticulos.ListenerDeFragment listener;
    private Button botonAgregar;

    public FragmentAgregarArticulo(FragmentListaDeArticulos.ListenerDeFragment listener) {
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

                Intent intent = new Intent(getContext(), ArticulosDAO.class);
                Bundle bundle = new Bundle();

                bundle.putSerializable(ArticulosDAO.NOMBRE, nombre);
                bundle.putSerializable(ArticulosDAO.PRECIO, costo);
                bundle.putSerializable(ArticulosDAO.DESCRIPCION, description);

                intent.putExtras(bundle);



                listener.volverAlFragmentLista();


            }
        });


        return view;
    }


    @Override
    public void recibirArticulo(Articulo articulo) {

    }

    @Override
    public void recibirBoton() {

    }

    @Override
    public void agregarALista(Articulo articulo) {

    }

    @Override
    public void volverAlFragmentLista() {

    }


}

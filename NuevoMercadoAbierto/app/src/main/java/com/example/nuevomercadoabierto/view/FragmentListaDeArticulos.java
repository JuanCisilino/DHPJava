package com.example.nuevomercadoabierto.view;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.nuevomercadoabierto.ListenerArticulo;
import com.example.nuevomercadoabierto.R;
import com.example.nuevomercadoabierto.controller.ControllerArticulos;
import com.example.nuevomercadoabierto.model.Articulo;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListaDeArticulos extends Fragment implements AdapterArticulo.ListenerDeAdapter
       {

    private Button botonAgregarArticulo;
    private RecyclerView recyclerView;
    private ListenerDeFragment listenerDeFragment;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_de_articulos, container, false);

        recyclerView = view.findViewById(R.id.fragmentArticulos_recycler);
        botonAgregarArticulo = view.findViewById(R.id.boton_AgregarArticulo);

        //crear el adapter

        final AdapterArticulo adapterArticulo = new AdapterArticulo(this);
        ControllerArticulos controllerArticulos = new ControllerArticulos();

        controllerArticulos.traerArticulos(new ListenerArticulo<List<Articulo>>() {
            @Override
            public void finish(List<Articulo> result) {
                adapterArticulo.setArticuloList(result);
            }
        });



        botonAgregarArticulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Vamos a crear un nuevo articulo", Toast.LENGTH_LONG).show();
                listenerDeFragment.recibirBoton();
            }
        });




        //setearle el layout manager (
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        //setearle el adapter
        recyclerView.setAdapter(adapterArticulo);


        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listenerDeFragment = (ListenerDeFragment) context;
    }

    @Override
    public void informarArticuloSeleccionado(Articulo articulo) {
        listenerDeFragment.recibirArticulo(articulo);
    }


    public interface ListenerDeFragment {
        public void recibirArticulo(Articulo articulo);
        public void recibirBoton();

    }
}

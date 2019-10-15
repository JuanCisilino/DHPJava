package com.example.mercadoabierto;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaDeArticulosFragment extends Fragment implements ArticuloAdapter.ListenerDelAdapter {

    public static final String CLAVE_ARTICULO = "claveArticulo";

    private RecyclerView recyclerViewArticulos;

    private NotificadorActivity listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vistaDelFragment = inflater.inflate(R.layout.fragment_lista_de_articulos, container, false);

        Bundle bundle = getArguments();

        final ArticuloAdapter adapter = new ArticuloAdapter(this);

        if (bundle != null) {
            Articulo articulo = (Articulo) bundle.getSerializable(CLAVE_ARTICULO);
            adapter.agregarArticulo(articulo);
        }

        recyclerViewArticulos = vistaDelFragment.findViewById(R.id.fragment_listadearticulos_recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);

        //adapter.notifyDataSetChanged();

        recyclerViewArticulos.setAdapter(adapter);

        recyclerViewArticulos.setLayoutManager(linearLayoutManager);





        return vistaDelFragment;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.listener = (NotificadorActivity) context;
    }

    @Override
    public void informarArticulo(Articulo articulo) {
        listener.recibirMensaje(articulo);
    }

    public interface NotificadorActivity {

        public void recibirMensaje(Articulo articulo);

        public void agregarArcticuloALista(Articulo articulo);

        public List<Articulo> generarLista();

    }

    public ListaDeArticulosFragment() {
        // Required empty public constructor
    }



}

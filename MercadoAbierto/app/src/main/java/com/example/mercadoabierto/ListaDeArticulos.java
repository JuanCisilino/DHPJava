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

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaDeArticulos extends Fragment {

    public static final String CLAVE_ARTICULO = "claveArticulo";


    private RecyclerView recyclerViewArticulos;
    private Button botonAgregar;



    private NotificadorActivity listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View vistaDelFragment = inflater.inflate(R.layout.fragment_lista_de_articulos, container, false);

        recyclerViewArticulos = vistaDelFragment.findViewById(R.id.fragment_listadearticulos_recyclerView);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false);

        ArticuloAdapter adapter = new ArticuloAdapter(generarLista());

        recyclerViewArticulos.setAdapter(adapter);

        recyclerViewArticulos.setLayoutManager(linearLayoutManager);



        botonAgregar = vistaDelFragment.findViewById(R.id.botonAgregarArticulo);


        botonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getContext(), AgregarArticulo.class);

                startActivity(intent);

            }
        });




        return vistaDelFragment;
    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.listener = (NotificadorActivity) context;
    }

    public interface NotificadorActivity{

        public void recibirMensaje(Articulo articulo);

    }
    public ListaDeArticulos() {
        // Required empty public constructor
    }

    private List<Articulo> generarLista(){

        List<Articulo> listaDeArticulos = new ArrayList<>();

        listaDeArticulos.add(
                new Articulo("Amoladora", "$500",
                        "Amoladora de 112mm, perfecta para trabajos de hobbie o profesionales.",
                        R.drawable.ic_launcher_background));

        listaDeArticulos.add(
                new Articulo("Taladro", "$350",
                        "Taladro con mandril de 13mm, perfecta para trabajos de hobbie o profesionales.",
                        R.drawable.ic_launcher_background));

        listaDeArticulos.add(
                new Articulo("Remachadora", "$400",
                        "Remachadora con bocas de hasta 5mm, perfecta para trabajos de hobbie o profesionales.",
                        R.drawable.ic_launcher_background));

        listaDeArticulos.add(
                new Articulo("Dildo", "$1500",
                        "Ideal para el bolsillo de la dama y el morral del caballero.",
                        R.drawable.ic_launcher_background));

        listaDeArticulos.add(
                new Articulo("Amoladora", "$500",
                        "Amoladora de 112mm, perfecta para trabajos de hobbie o profesionales.",
                        R.drawable.ic_launcher_background));

        listaDeArticulos.add(
                new Articulo("Taladro", "$350",
                        "Taladro con mandril de 13mm, perfecta para trabajos de hobbie o profesionales.",
                        R.drawable.ic_launcher_background));

        listaDeArticulos.add(
                new Articulo("Remachadora", "$400",
                        "Remachadora con bocas de hasta 5mm, perfecta para trabajos de hobbie o profesionales.",
                        R.drawable.ic_launcher_background));

        listaDeArticulos.add(
                new Articulo("Dildo", "$1500",
                        "Ideal para el bolsillo de la dama y el morral del caballero.",
                        R.drawable.ic_launcher_background));

        listaDeArticulos.add(
                new Articulo("Amoladora", "$500",
                        "Amoladora de 112mm, perfecta para trabajos de hobbie o profesionales.",
                        R.drawable.ic_launcher_background));

        listaDeArticulos.add(
                new Articulo("Taladro", "$350",
                        "Taladro con mandril de 13mm, perfecta para trabajos de hobbie o profesionales.",
                        R.drawable.ic_launcher_background));

        listaDeArticulos.add(
                new Articulo("Remachadora", "$400",
                        "Remachadora con bocas de hasta 5mm, perfecta para trabajos de hobbie o profesionales.",
                        R.drawable.ic_launcher_background));

        listaDeArticulos.add(
                new Articulo("Dildo", "$1500",
                        "Ideal para el bolsillo de la dama y el morral del caballero.",
                        R.drawable.ic_launcher_background));

        Bundle bundle = getArguments();

        Articulo articulo = (Articulo) bundle.getSerializable(CLAVE_ARTICULO);

        listaDeArticulos.add( new Articulo(articulo.getNombreDeArticulo(),articulo.getPrecioDeArticulo(),
                articulo.getDescripcionDeArticulo(),R.drawable.ic_launcher_foreground));

        return listaDeArticulos;
    }
}

package com.example.mercadoabierto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ListaDeArticulosFragment.NotificadorActivity,
                                                            AgregarArticuloFragment.NotificadorDeNuevoArticulo {

    private Button botonAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonAgregar = findViewById(R.id.botonAgregarArticulo);


        botonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                pegarFragment(new AgregarArticuloFragment());

            }
        });

        pegarFragment(new ListaDeArticulosFragment());

    }

    private void pegarFragment(Fragment fragment){

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainActivity_contenedorDeFragments,fragment,null)
                .commit();
    }


    @Override
    public void recibirMensaje(Articulo articulo) {
        //Intent intent = new Intent(MainActivity.this, AgregarArticuloFragment.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(ListaDeArticulosFragment.CLAVE_ARTICULO, articulo);
        ListaDeArticulosFragment listaDeArticulosFragment = new ListaDeArticulosFragment();
        listaDeArticulosFragment.setArguments(bundle);

        pegarFragment(listaDeArticulosFragment);
    }

    @Override
    public void agregarArcticuloALista(Articulo articulo) {

    }


    @Override
    public void seAgregoArticulo(Articulo articulo) {
        recibirMensaje(articulo);

    }

    public List<Articulo> generarLista() {

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


        return listaDeArticulos;
    }
}

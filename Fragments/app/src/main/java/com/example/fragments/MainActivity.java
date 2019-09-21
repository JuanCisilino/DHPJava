package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button botonCambiarVerde;
    private Button botonCambiarRojo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonCambiarRojo = findViewById(R.id.boton_Rojo);
        botonCambiarVerde = findViewById(R.id.boton_Verde);

        pegarFragment(new BlankFragment());

        botonCambiarVerde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pegarFragmentColor(Color.BLUE);

            }
        });

        botonCambiarRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentRojo fragmentRojo = new FragmentRojo();

                pegarFragment(fragmentRojo);


            }
        });


    }

    private void pegarFragment(Fragment unFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.contenedorDeFragments, unFragment, null);

        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }

    private void pegarFragmentColor(Integer color) {

        FragmentColor fragmentColor = new FragmentColor();

        Bundle bundleColor = new Bundle();

        bundleColor.putInt(FragmentColor.CLAVE_COLOR, color);

        fragmentColor.setArguments(bundleColor);

        pegarFragment(fragmentColor);
    }
}

package com.example.mercadoabierto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements ListaDeArticulos.NotificadorActivity{

    private Button botonAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonAgregar = findViewById(R.id.botonAgregarArticulo);


        botonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                pegarFragment(new AgregarArticulo());

            }
        });

        pegarFragment(new ListaDeArticulos());

    }

    private void pegarFragment(Fragment fragment){

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainActivity_contenedorDeFragments,fragment,null)
                .commit();
    }


    @Override
    public void recibirMensaje(Articulo articulo) {
        Intent intent = new Intent(MainActivity.this,AgregarArticulo.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(ListaDeArticulos.CLAVE_ARTICULO, articulo);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

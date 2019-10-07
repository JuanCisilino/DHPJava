package com.example.mercadoabierto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements ListaDeArticulos.NotificadorActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        bundle.putSerializable(ListaDeArticulos.CLAVE_ARTICULO, (Serializable) articulo);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

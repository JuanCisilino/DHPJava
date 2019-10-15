package com.example.nuevomercadoabierto.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.example.nuevomercadoabierto.R;
import com.example.nuevomercadoabierto.model.Articulo;

public class MainActivity extends AppCompatActivity implements FragmentListaDeArticulos.ListenerDeFragment, FragmentAgregarArticulo.ListerDeAgregarArticulo {


    private FragmentListaDeArticulos fragmentListaDeArticulos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentListaDeArticulos = new FragmentListaDeArticulos();
        pegarFragment(fragmentListaDeArticulos);
    }


    private void pegarFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainActivity_container, fragment)
                .addToBackStack(null)
                .commit();
    }



    @Override
    public void recibirArticulo(Articulo articulo) {
        //aca voy a cargar el fragmetn con el detalle del articulo
        Toast.makeText(this, articulo.getNombreDeArticulo(), Toast.LENGTH_SHORT).show();
        FragmentDescripcionDelArticulo fragmentDescripcionDelArticulo = new FragmentDescripcionDelArticulo();
        Bundle bundle = new Bundle();
        bundle.putSerializable(fragmentDescripcionDelArticulo.CLAVE_ARTICULO,articulo);
        fragmentDescripcionDelArticulo.setArguments(bundle);
        pegarFragment(fragmentDescripcionDelArticulo);
    }

    @Override
    public void recibirBoton() {
        pegarFragment(new FragmentAgregarArticulo());

    }


    @Override
    public void agregararticulo(Articulo articulo) {
        fragmentListaDeArticulos.agregarArticuo(articulo);
        onBackPressed();
    }
}
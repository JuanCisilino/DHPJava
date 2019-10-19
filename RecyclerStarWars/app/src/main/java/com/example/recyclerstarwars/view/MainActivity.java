package com.example.recyclerstarwars.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.example.recyclerstarwars.R;
import com.example.recyclerstarwars.controller.PeliculaController;
import com.example.recyclerstarwars.model.Pelicula;
import com.example.recyclerstarwars.utils.ResultListener;

public class MainActivity extends AppCompatActivity implements FragmentListaPeliculas.ListenerDeFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pegarFragment(new FragmentListaPeliculas());
    }

    private void pegarFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainActivity_container,fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void recibirPelicula(final Pelicula pelicula) {

        Toast.makeText(this, pelicula.getTitulo(), Toast.LENGTH_SHORT).show();

        Fragment_DetallePelicula fragment_detallePelicula = new Fragment_DetallePelicula();

        Bundle bundle = new Bundle();

        bundle.putSerializable(fragment_detallePelicula.CLAVE_PELICULA, pelicula);

        fragment_detallePelicula.setArguments(bundle);

        pegarFragment(fragment_detallePelicula);

        PeliculaController peliculaController = new PeliculaController();

        peliculaController.traePeli(3, new ResultListener<Pelicula>() {
            @Override
            public void finish(Pelicula result) {
                Toast.makeText(MainActivity.this, pelicula.getTitulo(), Toast.LENGTH_LONG).show();
            }
        });
    }
}

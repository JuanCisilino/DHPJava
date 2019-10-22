package com.example.appmuvi.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.appmuvi.R;
import com.example.appmuvi.controller.ControllerPelicula;
import com.example.appmuvi.model.Famoso;
import com.example.appmuvi.model.Pelicula;
import com.example.appmuvi.utils.ListenerPelicula;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
//Api Key--> https://api.themoviedb.org/3/movie/550?api_key=41c70e6b99d8ae34c17c9c34fd81e344
public class MainActivity extends AppCompatActivity implements FragmentListaDePeliculas.ListenerDeFragment, FragmentListaFamosos.ListenerDeFragment,
        NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private AdapterPeliculas adapterPeliculas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);


        navigationView.setNavigationItemSelectedListener(this);




        pegarFragment(new FragmentListaDePeliculas());
        pegarFragmentFamoso(new FragmentListaFamosos());
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Integer id = menuItem.getItemId();

        switch (id) {
            case R.id.genero_accion:
                Toast.makeText(this, "Acceso a peliculas de Accion", Toast.LENGTH_LONG).show();
                break;

            case R.id.genero_animacion:
                Toast.makeText(this, "Acceso a peliculas de Animacion", Toast.LENGTH_LONG).show();
                break;

            case R.id.genero_aventura:
                Toast.makeText(this, "Acceso a peliculas de Aventura", Toast.LENGTH_LONG).show();
                break;

            case R.id.genero_belica:
                Toast.makeText(this, "Acceso a peliculas de Belica", Toast.LENGTH_LONG).show();
                break;

            case R.id.genero_ciencia_ficcion:
                Toast.makeText(this, "Acceso a peliculas de Ciencia Ficcion", Toast.LENGTH_LONG).show();
                break;

            case R.id.genero_comedia:
                Toast.makeText(this, "Acceso a peliculas de Comedia", Toast.LENGTH_LONG).show();
                break;
        }

        drawerLayout.closeDrawers();

        return false;
    }

    @Override
    public void recibirPelicula(final Pelicula pelicula) {
 /*       Toast.makeText(this, pelicula.getTitulo(), Toast.LENGTH_SHORT).show();

        Fra fragment_detallePelicula = new Fragment_DetallePelicula();

        Bundle bundle = new Bundle();

        bundle.putSerializable(fragment_detallePelicula.CLAVE_PELICULA, pelicula);

        fragment_detallePelicula.setArguments(bundle);

        pegarFragment(fragment_detallePelicula);

        ControllerPelicula peliculaController = new ControllerPelicula();

        peliculaController.traePeli(this,new ListenerPelicula<Pelicula>() {
            @Override
            public void finish(Pelicula result) {
                Toast.makeText(MainActivity.this, pelicula.getTitulo(), Toast.LENGTH_LONG).show();
            }
        });
*/
    }

    private void pegarFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contenedor_Fragment,fragment)
                .addToBackStack(null)
                .commit();
    }

    private void pegarFragmentFamoso(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contenedor_FragmentFamoso,fragment)
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void recibirFamoso(Famoso famoso) {

    }
}
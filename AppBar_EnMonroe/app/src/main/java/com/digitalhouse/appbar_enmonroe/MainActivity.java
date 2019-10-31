package com.digitalhouse.appbar_enmonroe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

//la main implementa el listener del navigation para tener como metodo su comportamiento
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar_main_activity);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.open_drawer,
                R.string.close_drawer);

        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();
        //le seteo el on click le digo this por que la main activity implementa el listener
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        return true;
    }

    //el metodo que le asigna el onclick a cada elemnto
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //menuitem es el elemento seleccionado
        Integer id = menuItem.getItemId();
        //uso un switch para ponerle un comportamiento distinto a cada boton
        switch (id) {
            case R.id.menuPrincipal_perfil:
                Toast.makeText(this, "Entrado al perfil del usuario", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuPrincipal_favoritos:
                Toast.makeText(this, "el usuario quiere ir a fovoritos", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuPrincipal_settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                break;

            case R.id.menuPrincipal_logout:
                Toast.makeText(this, "Logout exitoso", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawers();
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.pasarPantalla:
            startActivity(new Intent(MainActivity.this, SegundaActivity.class));
            break;

            case R.id.toast:
            Toast.makeText(MainActivity.this, "Tengo mas hambre que el chavo", Toast.LENGTH_LONG).show();
            break;
        }
        return true;
    }
}
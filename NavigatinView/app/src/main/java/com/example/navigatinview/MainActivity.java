package com.example.navigatinview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Integer id = menuItem.getItemId();

        switch (id) {
            case R.id.menuPrincipal_Favoritos:
                Toast.makeText(this, "El usuario quiere ir a favoritos", Toast.LENGTH_LONG).show();
                break;

            case R.id.menuPrincipal_logout:
                Toast.makeText(this, "Logout exitoso", Toast.LENGTH_LONG).show();
                break;

            case R.id.menuPrincipal_Perfil:
                Toast.makeText(this, "Entrando al perfil del usuario", Toast.LENGTH_LONG).show();
                break;

            case R.id.menuPrincipal_Settings:
                Toast.makeText(this, "Acceder a los settings", Toast.LENGTH_LONG).show();
                break;
        }

        drawerLayout.closeDrawers();
        return false;
    }
}

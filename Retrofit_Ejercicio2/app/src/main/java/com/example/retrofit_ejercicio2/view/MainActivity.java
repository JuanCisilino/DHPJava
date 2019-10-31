package com.example.retrofit_ejercicio2.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.retrofit_ejercicio2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pegarFragment(new Fragment_ListaDeProductos());

    }

    private void pegarFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainActivity_container, fragment)
                .addToBackStack(null)
                .commit();
    }
}

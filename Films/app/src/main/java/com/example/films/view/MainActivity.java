package com.example.films.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.films.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pegarFragment(new FragmentListaPeliculas());
    }

    private void pegarFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.mainActivity_container, fragment).commit();
    }
}

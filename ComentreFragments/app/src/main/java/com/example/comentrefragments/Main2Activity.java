package com.example.comentrefragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();

        Activity2 fragment = new Activity2();

        fragment.setArguments(bundle);

        pegarFragment(fragment);

    }

    private void pegarFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contenedorDeFragment2, fragment, null)
                .commit();
    }


}

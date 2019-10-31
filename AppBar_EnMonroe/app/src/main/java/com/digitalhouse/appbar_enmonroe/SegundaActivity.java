package com.digitalhouse.appbar_enmonroe;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SegundaActivity extends AppCompatActivity {

    private Toolbar segunda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        segunda = findViewById(R.id.toolbar_segunda_activity);

        setSupportActionBar(segunda);

        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

    }
}

package com.digitalhouse.androidcolapsabletoolbar;


import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // We need to set the toolbar as ActionBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Find the Collapse ToolBar component
        final CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.colapseToolbar);
        // Set Title
        collapsingToolbarLayout.setTitle("Android");
        // Set Title Expanded Color
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);
        // Set Scrim Color
        collapsingToolbarLayout.setContentScrimResource(R.color.colorPrimary);
        collapsingToolbarLayout.setStatusBarScrimResource(R.color.colorPrimaryDark);

        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "FAB", Toast.LENGTH_SHORT).show();
            }
        });


        // Create the data model
        Dato dato = new Dato(getResources().getString(R.string.title), getResources().getString(R.string.message));

        List<Dato> lista = new ArrayList<>();
        for (Integer i = 0; i < 10; i++) {
            lista.add(dato);
        }

        // Create the Adapter
        MiAdapter adapter = new MiAdapter(lista);

        // Find the Recycler View
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // Set Layout Manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        // Set Adapter
        recyclerView.setAdapter(adapter);
        // Tell the recycler size will not change
        recyclerView.setHasFixedSize(true);
    }
}

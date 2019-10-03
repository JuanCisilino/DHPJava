package com.example.relojmundial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityFinal extends AppCompatActivity {

    public static final String horasContadas = "00";
    public static final String minutosContados = "00";

    private TextView horaFrancia, minutosFrancia, horaChina, minutoChina, horaSuda, minutoSuda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        buscarVariables();


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        Integer horas = bundle.getInt(horasContadas);
        Integer minutos = bundle.getInt(minutosContados);


        horaFrancia.setText(horas.toString());

        minutosFrancia.setText(minutos.toString());

    }

    private void buscarVariables(){
        horaFrancia = findViewById(R.id.horaEnFrancia);
        minutosFrancia = findViewById(R.id.minutosEnFrancia);
    }

}

package com.example.relojmundial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PatternMatcher;
import android.widget.TextView;

public class ActivityFinal extends AppCompatActivity {

    public static final String horasContadas = "horasContadass";
    public static final String minutosContados = "minutosContados";
    public static final String PM = "PM";

    private TextView horaFrancia, minutosFrancia, horaChina, minutoChina, horaSuda, minutoSuda,
                    ampmchina, ampmfrancia, ampmsuda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        buscarVariables();


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        Integer horas = bundle.getInt(horasContadas);
        Integer minutos = bundle.getInt(minutosContados);
        Boolean pM = bundle.getBoolean(PM);

        Integer francia = horas + 4;
        if (francia > 12 && pM) {
            francia = francia - 12;
            ampmfrancia.setText("AM");
            horaFrancia.setText(francia.toString());
            minutosFrancia.setText(minutos.toString());
        }else if (francia > 12 && !pM){
            francia = francia - 12;
            ampmfrancia.setText("PM");
            horaFrancia.setText(francia.toString());
            minutosFrancia.setText(minutos.toString());
        }
        else if (pM) {
            ampmfrancia.setText("PM");
            horaFrancia.setText(francia.toString());
            minutosFrancia.setText(minutos.toString());
        }else {
            ampmfrancia.setText("AM");
            horaFrancia.setText(francia.toString());
            minutosFrancia.setText(minutos.toString());
        }


        Integer china = horas + 11;
        if (china > 12 && pM) {
            china = china - 12;
            ampmchina.setText("AM");
            horaChina.setText(china.toString());
            minutoChina.setText(minutos.toString());
        } else if (china > 12 && !pM) {
            china = china - 12;
            ampmchina.setText("PM");
            horaChina.setText(china.toString());
            minutoChina.setText(minutos.toString());
        }else if (pM) {
            ampmchina.setText("PM");
            horaChina.setText(china.toString());
            minutoChina.setText(minutos.toString());
        }else {
            ampmchina.setText("AM");
            horaChina.setText(china.toString());
            minutoChina.setText(minutos.toString());
        }


        Integer suda = horas + 5;
        if (suda > 12 && pM) {
            suda = suda - 12;
            ampmsuda.setText("AM");
            horaSuda.setText(suda.toString());
            minutoSuda.setText(minutos.toString());
        }else if (suda > 12 && !pM) {
            suda = suda - 12;
            ampmsuda.setText("PM");
            horaSuda.setText(suda.toString());
            minutoSuda.setText(minutos.toString());
        }else if (pM){
            ampmsuda.setText("PM");
            horaSuda.setText(suda.toString());
            minutoSuda.setText(minutos.toString());
        }else {
            ampmsuda.setText("AM");
            horaSuda.setText(suda.toString());
            minutoSuda.setText(minutos.toString());
        }

    }

    private void buscarVariables(){
        horaFrancia = findViewById(R.id.horaEnFrancia);
        minutosFrancia = findViewById(R.id.minutosEnFrancia);
        horaChina = findViewById(R.id.horaEnChina);
        minutoChina = findViewById(R.id.minutosEnChina);
        horaSuda = findViewById(R.id.horaEnSuda);
        minutoSuda = findViewById(R.id.minutosEnSuda);
        ampmfrancia = findViewById(R.id.ampmEnFrancia);
        ampmchina = findViewById(R.id.ampmEnChina);
        ampmsuda = findViewById(R.id.ampmEnSuda);
    }

}

package com.example.relojmundial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private Button sumarHoras, sumarMinutos, restarHoras, restarMinutos, botonOk;
    private TextView horas, minuto;
    private Integer contadorHoras, contadorMinutos;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button sumarHoras = findViewById(R.id.activitydos_boton_sumarHoras);
        TextView horas = findViewById(R.id.mainActivity_textView_contadorHoras);
        Button restarHoras = findViewById(R.id.mainActivity_boton_restarHoras);
        Button restarMinutos = findViewById(R.id.mainActivity_boton_restarMinutos);
        TextView minuto = findViewById(R.id.activitydos_textView_contadorMinutos);
        Button sumarMinutos = findViewById(R.id.activitydos_boton_sumarMinutos);

        Button botonOk = findViewById(R.id.botonOK);

        contadorHoras = 00;
        contadorMinutos = 00;


        sumarHoras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorHoras = contadorHoras + 1;
                modificarHoras();
            }
        });

        restarHoras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorHoras = contadorHoras - 1;
                modificarHoras();
            }
        });

        sumarMinutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorMinutos = contadorMinutos + 1;
                modificarMinutos();
            }
        });

        restarMinutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorMinutos = contadorMinutos - 1;
                modificarMinutos();
            }
        });



    }

    private void modificarHoras(){
        horas.setText(contadorHoras.toString());
    }

    private void modificarMinutos(){
        minuto.setText(contadorMinutos.toString());
    }
}

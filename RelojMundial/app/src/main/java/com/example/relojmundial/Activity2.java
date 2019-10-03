package com.example.relojmundial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class Activity2 extends AppCompatActivity {

    private Button sumarHoras, sumarMinutos, restarHoras, restarMinutos, botonOk;
    private TextView horas, minuto;
    private Integer contadorHoras, contadorMinutos;
    private ToggleButton ampm;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        sumarHoras = findViewById(R.id.boton_sumarHoras);
        horas = findViewById(R.id.textView_contadorHoras);
        restarHoras = findViewById(R.id.boton_restarHoras);
        restarMinutos = findViewById(R.id.boton_restarMinutos);
        minuto = findViewById(R.id.textView_contadorMinutos);
        sumarMinutos = findViewById(R.id.boton_sumarMinutos);

        botonOk = findViewById(R.id.botonOK);
        ampm = findViewById(R.id.botonAMPM);

        contadorHoras = 0;
        contadorMinutos = 0;



        sumarHoras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorHoras = contadorHoras + 1;
                if (contadorHoras > 12) {
                    contadorHoras = 0;
                    modificarHoras();
                }else {
                    modificarHoras();
                }
            }
        });

        restarHoras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorHoras = contadorHoras - 1;
                if (contadorHoras < 0) {
                    contadorHoras = 12;
                    modificarHoras();
                }else {
                    modificarHoras();
                }
            }
        });

        sumarMinutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorMinutos = contadorMinutos + 1;
                if (contadorMinutos > 59) {
                    contadorMinutos = 0;
                    modificarMinutos();
                } else {
                    modificarMinutos();
                }
            }

        });

        restarMinutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorMinutos = contadorMinutos - 1;
                if (contadorMinutos < 0 ) {
                    contadorMinutos = 59;
                    modificarMinutos();
                } else {
                    modificarMinutos();
                }
            }
        });

        botonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String horaFinal = horas.getText().toString();
                Integer horaEnNumero = Integer.parseInt(horaFinal);


                Intent intent = new Intent(Activity2.this, ActivityFinal.class);
                Bundle bundle = new Bundle();

                bundle.putInt(ActivityFinal.horasContadas, horaEnNumero);
                bundle.putInt(ActivityFinal.minutosContados, contadorMinutos);

                intent.putExtras(bundle);

                startActivity(intent);
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

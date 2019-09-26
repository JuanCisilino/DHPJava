package com.example.ejercitacion3formulariocompleto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityFormulario extends AppCompatActivity {

    private EditText nombre, apellido, edad, carrera, email;

    private CheckBox torneos, meetup, asados;

    private Button enviar;

    private void encontrarVariables(){
        nombre = findViewById(R.id.nombre_EditText);
        apellido = findViewById(R.id.apellido_EditText);
        edad = findViewById(R.id.edad_EditText);
        carrera = findViewById(R.id.carrera_EditText);
        email = findViewById(R.id.mail_EditText);
        torneos = findViewById(R.id.torneo_checkBox);
        meetup = findViewById(R.id.meetup_checkBox);
        asados = findViewById(R.id.asados_checkBox);
        enviar = findViewById(R.id.boton_Enviar);

    }

    private void pasarVariables(){

        String edades = edad.getText().toString();
        Integer anos = Integer.parseInt(edades);


        Boolean torneosboolean = torneos.isChecked();
        Boolean meetupboolean = meetup.isChecked();
        Boolean asadosboolean = asados.isChecked();

        Intent intent = new Intent(ActivityFormulario.this, ActivityFinal.class);

        Bundle bundle = new Bundle();

        bundle.putString(ActivityFinal.NOMBRE, nombre.getText().toString());
        bundle.putString(ActivityFinal.APELLIDO, apellido.getText().toString());
        bundle.putInt(ActivityFinal.EDAD, anos);
        bundle.putString(ActivityFinal.CARRERA, carrera.getText().toString());
        bundle.putString(ActivityFinal.EMAIL, email.getText().toString());


        bundle.putBoolean(ActivityFinal.TORNEOS, torneosboolean);
        bundle.putBoolean(ActivityFinal.MEETUP, meetupboolean);
        bundle.putBoolean(ActivityFinal.ASADOS, asadosboolean);

        intent.putExtras(bundle);

        startActivity(intent);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        encontrarVariables();


        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pasarVariables();



            }
        });

    }




}

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
        String name = nombre.getText().toString();
        String apech = apellido.getText().toString();
        Integer anos = Integer.parseInt(edad.getText().toString());
        String carrche = carrera.getText().toString();
        String mail = email.getText().toString();

        boolean torneosboolean = torneos.isChecked();
        boolean meetupboolean = meetup.isChecked();
        boolean asadosboolean = asados.isChecked();

        Intent intent = new Intent(ActivityFormulario.this, ActivityFinal.class);

        intent.putExtra("nombre", name);
        intent.putExtra("apellido", apech);
        intent.putExtra("edad", anos);
        intent.putExtra("carrera", carrche);
        intent.putExtra("email", mail);

        Bundle bundle = new Bundle();

        bundle.putString(ActivityFinal.NOMBRE, name);
        bundle.putString(ActivityFinal.APELLIDO, apech);
        bundle.putInt(ActivityFinal.EDAD, anos);
        bundle.putString(ActivityFinal.CARRERA, carrche);
        bundle.putString(ActivityFinal.EMAIL, mail);


        bundle.putBoolean(ActivityFinal.TORNEOS, torneosboolean);
        bundle.putBoolean(ActivityFinal.MEETUP, meetupboolean);
        bundle.putBoolean(ActivityFinal.ASADOS, asadosboolean);


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

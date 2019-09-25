package com.example.ejercitacion3formulariocompleto;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityFinal extends AppCompatActivity {

    public static final String NOMBRE = "Nombre";
    public static final String APELLIDO = "Apellido";
    public static final Integer EDAD = 0 ;
    public static final String CARRERA = "Carrera";
    public static final String EMAIL = "Email";
    public static final String TORNEOS = "Torneos";
    public static final String MEETUP = "Reuniones";
    public static final String ASADOS = "Asados";


    private TextView nombre, apellido, edad, carrera, email, asados, mitup, torneos;




    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        buscarVariables();


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();


        String name = bundle.getString(NOMBRE);
        nombre.setText(name);

        String ape = bundle.getString(APELLIDO);
        apellido.setText(ape);

        Integer anios = bundle.getInt(EDAD));
        edad.setin(anios);

        String carre = bundle.getString(CARRERA);
        carrera.setText(carre);

        String mail = bundle.getString(EMAIL);
        email.setText(mail);

        Boolean meetup = bundle.getBoolean(MEETUP);
        Boolean asado = bundle.getBoolean(ASADOS);
        Boolean torneo = bundle.getBoolean(TORNEOS);

        if (meetup) {
            mitup.setText("Reuniones informativas o recreativas");
        }

        if (asado) {
            asados.setText("Agregarlo al proximo Asado!!");
        }

        if (torneo) {
            torneos.setText("Nuevos Torneos");
        }


    }

    private void buscarVariables() {

        nombre = findViewById(R.id.textView_nombre);
        apellido = findViewById(R.id.textView_apellido);
        edad = findViewById(R.id.textView_edad);
        carrera = findViewById(R.id.textView_carrera);
        email = findViewById(R.id.textView_email);
        asados = findViewById(R.id.textView_asados);
        mitup = findViewById(R.id.textView_meetup);
        torneos = findViewById(R.id.textView_torneos);

    }

}

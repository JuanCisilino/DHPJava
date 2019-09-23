package com.example.ejercitacion3formulariocompleto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityFinal extends AppCompatActivity {

    public static final String NOMBRE = "Nombre";
    public static final String APELLIDO = "Apellido";
    public static final String EDAD = "";
    public static final String CARRERA = "Carrera";
    public static final String EMAIL = "Email";
    public static final String TORNEOS = "Torneos";
    public static final String MEETUP = "Reuniones";
    public static final String ASADOS = "Asados";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        TextView nombre = findViewById(R.id.textView_nombre);
        Intent intentname = getIntent();
        Bundle bundlename = intentname.getExtras();
        String name = bundlename.getString(NOMBRE);
        nombre.setText(name);

        TextView apellido = findViewById(R.id.textView_apellido);
        Intent intentape = getIntent();
        Bundle bundleape = intentape.getExtras();
        String ape = bundleape.getString(APELLIDO);
        apellido.setText(ape);

        TextView anos = findViewById(R.id.textView_edad);
        Intent intent = getIntent();
        Bundle bundledad = intent.getExtras();
        String anios = String.valueOf(bundledad.getInt(EDAD));
        anos.setText(anios);

        TextView carrera = findViewById(R.id.textView_carrera);
        Intent intentcar = getIntent();
        Bundle bundlecar = intentcar.getExtras();
        String carre = bundlecar.getString(CARRERA);
        carrera.setText(carre);

        TextView email = findViewById(R.id.textView_email);
        Intent intentma = getIntent();
        Bundle bundlema = intentma.getExtras();
        String mail = bundlema.getString(EMAIL);
        email.setText(mail);

        TextView textView =findViewById(R.id.textView_opcioneselegidas);

        CheckBox torn = findViewById(R.id.torneo_checkBox);
        Intent intchetor = getIntent();
        Bundle bundletorn = intchetor.getExtras();
        String torneo = bundletorn.getString(TORNEOS);

        CheckBox meet = findViewById(R.id.meetup_checkBox);
        Intent intemeet = getIntent();
        Bundle bundlemeet = intemeet.getExtras();
        String mitup = bundlemeet.getString(MEETUP);

        CheckBox asad = findViewById(R.id.asados_checkBox);
        Intent intasa = getIntent();
        Bundle bundlasa = intasa.getExtras();
        String asado = bundlasa.getString(ASADOS);

        textView.setText(torneo + mitup + asado);

    }
}

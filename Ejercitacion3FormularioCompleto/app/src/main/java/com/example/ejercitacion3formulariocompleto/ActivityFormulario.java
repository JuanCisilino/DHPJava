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

    private EditText nombre;
    private EditText apellido;
    private EditText edad;
    private EditText carrera;
    private EditText email;
    private CheckBox torneos;
    private CheckBox meetup;
    private CheckBox asados;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        nombre = findViewById(R.id.nombre_EditText);
        apellido = findViewById(R.id.apellido_EditText);
        edad = findViewById(R.id.edad_EditText);
        carrera = findViewById(R.id.carrera_EditText);
        email = findViewById(R.id.mail_EditText);
        torneos = findViewById(R.id.torneo_checkBox);
        meetup = findViewById(R.id.meetup_checkBox);
        asados = findViewById(R.id.asados_checkBox);
        enviar = findViewById(R.id.boton_Enviar);


        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String name = nombre.getText().toString();
                String apech = apellido.getText().toString();
                int anos = Integer.parseInt(edad.getText().toString());
                String carrche = carrera.getText().toString();
                String mail = email.getText().toString();
//                (name.length() > 2) && (apech.length() > 2)&& (anos > 7 && anos < 100)
//                        && (carrche.length() > 5) && (mail.contains("@".toString()))
                if ((name.length() > 2) && (apech.length() > 2) && (carrche.length() > 5) && (mail.contains("@".toString()))) {

                    Bundle nombre = new Bundle();
                    nombre.putString(ActivityFinal.NOMBRE, name);

                    Bundle apellido = new Bundle();
                    apellido.putString(ActivityFinal.APELLIDO, apech);

                    Bundle edad = new Bundle();
                    edad.putInt(String.valueOf(ActivityFinal.EDAD), anos);

                    Bundle carrera = new Bundle();
                    carrera.putString(ActivityFinal.CARRERA, carrche);

                    Bundle email = new Bundle();
                    email.putString(ActivityFinal.EMAIL, mail);

                    Intent intent = new Intent(ActivityFormulario.this, ActivityFinal.class);

                    intent.putExtras(nombre);
                    intent.putExtras(apellido);
                    intent.putExtras(edad);
                    intent.putExtras(carrera);
                    intent.putExtras(email);

                    startActivity(intent);


                } else {

                    Toast.makeText(ActivityFormulario.this,
                            "Falto algun campo o algun dato", Toast.LENGTH_LONG).show();

                }

                if (torneos.isChecked()) {
                    String torneo = "Torneos";
                    Bundle torne = new Bundle();
                    torne.putString(ActivityFinal.TORNEOS, torneo);
                    Intent intent = new Intent(ActivityFormulario.this, ActivityFinal.class);
                    intent.putExtras(torne);
                }

                else if (meetup.isChecked()) {
                    String metup = "Reuniones";
                    Bundle mitup = new Bundle();
                    mitup.putString(ActivityFinal.MEETUP, metup);
                    Intent intent = new Intent(ActivityFormulario.this, ActivityFinal.class);
                    intent.putExtras(mitup);
                }

                else if (asados.isChecked()) {
                    String asado = "Asados";
                    Bundle asados = new Bundle();
                    asados.putString(ActivityFinal.ASADOS, asado);
                    Intent intent = new Intent(ActivityFormulario.this, ActivityFinal.class);
                    intent.putExtras(asados);
                }

                else {
                    System.out.println("algo salio mal!!");
                }

            }
        });

    }




}

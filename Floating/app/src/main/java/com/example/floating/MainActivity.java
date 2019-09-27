package com.example.floating;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout textInputLayoutNombre, textInputLayoutContrasenia;
    private TextInputEditText textInputEditTextNombre, textInputEditTextContrasenia;
    private FloatingActionButton floatingActionButton;
    private CoordinatorLayout coordinatorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        encontrarVistas();

        textInputEditTextNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.length() < 4) {

                    textInputLayoutNombre.setError("El nombre debe tener mas de 3 letras");

                } else {

                    textInputLayoutNombre.setError(null);

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        textInputEditTextContrasenia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.length() < 7) {

                    textInputLayoutContrasenia.setError("La contraseña debe tener al menos 6 letras");

                } else {

                    textInputLayoutContrasenia.setError(null);

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (textInputEditTextNombre.getText().toString().length() > 3 && textInputEditTextContrasenia.getText().toString().length() > 6) {

                    Snackbar.make(coordinatorLayout, "Login Exitoso", Snackbar.LENGTH_LONG).show();

                }
            }
        });


    }

    private void encontrarVistas() {

        textInputLayoutNombre = findViewById(R.id.textInputNombre);
        textInputLayoutContrasenia = findViewById(R.id.textInputContraseña);
        textInputEditTextNombre = findViewById(R.id.editTextNombre);
        textInputEditTextContrasenia = findViewById(R.id.editTextContrasenia);
        floatingActionButton = findViewById(R.id.botonfloating);
        coordinatorLayout = findViewById(R.id.coordinador);

    }
}

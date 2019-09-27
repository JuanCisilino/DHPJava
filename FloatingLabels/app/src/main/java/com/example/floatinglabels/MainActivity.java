package com.example.floatinglabels;

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

    private TextInputLayout textInputLayoutNombre, textInputLayoutContraseña;
    private TextInputEditText textInputEditTextNombre, textInputEditTextApellido;
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

                if (charSequence.length() < 3){
                    textInputLayoutNombre.setError("Pone mas de 3 letras, las pilas!!!");
                } else {
                    textInputLayoutNombre.setError(null);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        textInputEditTextApellido.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() < 6){
                    textInputLayoutContraseña.setError("Contraseña muy corta");
                } else {
                    textInputLayoutContraseña.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

/*        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (textInputEditTextNombre.getText().toString().length() < 3){
                    textInputLayoutNombre.setError("Oriental no aceptado!");
                } else {
                    textInputLayoutNombre.setError(null);
                    Snackbar.make(coordinatorLayout, "Login exitoso", Snackbar.LENGTH_LONG).show();
                }
            }
        });*/
    }

    private void encontrarVistas() {
        textInputLayoutNombre = findViewById(R.id.textinputNombre);
        textInputLayoutContraseña = findViewById(R.id.textinputContraseña);
        floatingActionButton = findViewById(R.id.floatinActionButon);
        textInputEditTextNombre = findViewById(R.id.edittextNombre);
        textInputEditTextApellido = findViewById(R.id.edittextApellido);
        coordinatorLayout = findViewById(R.id.coordinadorLayout);

    }
}

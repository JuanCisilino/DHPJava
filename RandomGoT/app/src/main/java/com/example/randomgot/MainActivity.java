package com.example.randomgot;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imagenDeHeroe;
    private Button botonDescubrir;
    private TextView nombreDelHeroe;
    private Random aleatorio = new Random();
    private Integer numeroAleatorio;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonDescubrir = findViewById(R.id.botonDescubrir);




        botonDescubrir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                numeroAleatorio = aleatorio.nextInt(6);
                imagenDeHeroe = findViewById(R.id.imagenDeHeroe);
                nombreDelHeroe = findViewById(R.id.night_king);
                if (numeroAleatorio == 1){
                    imagenDeHeroe.setImageResource(R.drawable.cersei);
                    nombreDelHeroe.setText("Cersei");
                }
                else if (numeroAleatorio == 2) {
                    imagenDeHeroe.setImageResource(R.drawable.daenerys);
                    nombreDelHeroe.setText("Daenaerys");
                }else if (numeroAleatorio == 3) {
                    imagenDeHeroe.setImageResource(R.drawable.jonsnow);
                    nombreDelHeroe.setText("Jon Snow");
                }else if (numeroAleatorio == 4) {
                    imagenDeHeroe.setImageResource(R.drawable.tyrion);
                    nombreDelHeroe.setText("Tyrion");
                }else {
                    imagenDeHeroe.setImageResource(R.drawable.nightking);
                    nombreDelHeroe.setText("Night King");
                }

            }
        });
    }
}

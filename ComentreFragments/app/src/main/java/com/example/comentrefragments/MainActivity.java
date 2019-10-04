package com.example.comentrefragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Activity1.NotificadorActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pegarFragment(new Activity1());
    }

    private void pegarFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contenedorDeFragment1, fragment, null)
                .commit();
    }

    @Override
    public void recibirMensaje(String user, String pass) {
        Intent intent = new Intent(this, Main2Activity.class);
        Bundle bundle = new Bundle();

        bundle.putString(Activity2.CLAVE_USERNAME, user);
        bundle.putString(Activity2.CLAVE_PASS, pass);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

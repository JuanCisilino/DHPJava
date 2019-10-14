package com.example.applist.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.example.applist.R;
import com.example.applist.model.Invitado;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements FragmentListaDeInvitados.ListenerDeFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pegarFragment(new FragmentListaDeInvitados());
    }

    private void pegarFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainActivity_container,fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void recibirInvitado(Invitado invitado) {
        Toast.makeText(this, invitado.getNombre(), Toast.LENGTH_LONG).show();
        FragmentDetalleDelInvitado fragmentDetalleDelInvitado= new FragmentDetalleDelInvitado();
        Bundle bundle = new Bundle();
        bundle.putSerializable(FragmentDetalleDelInvitado.CLAVE_INVITADO, invitado);
        fragmentDetalleDelInvitado.setArguments(bundle);
        pegarFragment(fragmentDetalleDelInvitado);
    }
}

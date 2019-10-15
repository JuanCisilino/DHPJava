package com.example.applist.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.applist.R;
import com.example.applist.model.Invitado;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetalleDelInvitado extends Fragment {

    public static final String CLAVE_INVITADO = "claveInvitado";

    private TextView textViewNombre;
    private TextView textViewApellido;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle_del_invitado, container, false);

        textViewNombre = view.findViewById(R.id.textView_detalle_Nombre);
        textViewApellido = view.findViewById(R.id.textView_detalle_Apellido);

        Bundle bundle = getArguments();
        Invitado invitadoSeleccionado = (Invitado) bundle.getSerializable(CLAVE_INVITADO);

        textViewNombre.setText(invitadoSeleccionado.getNombre());
        textViewApellido.setText(invitadoSeleccionado.getApellido());

        return view;
    }

}

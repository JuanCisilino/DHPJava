package com.example.comentrefragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Activity2 extends Fragment {

    public static final String CLAVE_USERNAME  = "usuario";
    public static final String CLAVE_PASS = "Password";

    private TextView informacion;

    public Activity2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_activity2, container, false);

        informacion = view.findViewById(R.id.textViewFinal);

        Bundle bundle = getArguments();

        String username = bundle.getString(CLAVE_USERNAME);
        String password = bundle.getString(CLAVE_PASS);

        informacion.setText(username + " " + password);

        return view;
    }

}

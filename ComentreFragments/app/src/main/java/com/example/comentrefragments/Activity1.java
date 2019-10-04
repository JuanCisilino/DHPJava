package com.example.comentrefragments;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Activity1 extends Fragment {

    private EditText user, pass;
    private Button login;

    private NotificadorActivity listener;


    public Activity1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vistaFinal =  inflater.inflate(R.layout.fragment_activity1, container, false);

        user = vistaFinal.findViewById(R.id.usernameFragment1);
        pass = vistaFinal.findViewById(R.id.passFragment1);
        login = vistaFinal.findViewById(R.id.loginFragment1);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = user.getText().toString();
                String password = pass.getText().toString();

                listener.recibirMensaje(username,password);


            }
        });

        return vistaFinal;
    }



    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (NotificadorActivity) context;
    }


    public interface NotificadorActivity {

        public void recibirMensaje(String user, String pass);
    }


}

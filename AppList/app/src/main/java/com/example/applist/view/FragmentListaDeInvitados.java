package com.example.applist.view;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.applist.R;
import com.example.applist.ResultListener;
import com.example.applist.controller.ControllerInvitado;
import com.example.applist.model.Invitado;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentListaDeInvitados extends Fragment implements AdapterInvitado.ListenerDelAdapter {


    private RecyclerView recyclerView;
    private ListenerDeFragment listenerDeFragment;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista_de_invitados, container, false);
        //encontrar el recycler
        recyclerView = view.findViewById(R.id.fragmentInvitados_recycler);


        //crear el adapter
        final AdapterInvitado adapterInvitado = new AdapterInvitado(this);

        ControllerInvitado controllerInvitado = new ControllerInvitado();

        controllerInvitado.traerinvitados(new ResultListener<List<Invitado>>() {
            @Override
            public void finish(List<Invitado> result) {
                adapterInvitado.setInvitadoList(result);
            }
        });

        //setearle el layout manager (
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recyclerView.setAdapter(adapterInvitado);

        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listenerDeFragment = (ListenerDeFragment) context;
    }

    @Override
    public void informarInvitadoSeleccionada(Invitado invitado) {
        listenerDeFragment.recibirInvitado(invitado);
    }

    public interface ListenerDeFragment {
        public void recibirInvitado(Invitado invitado);
    }
}

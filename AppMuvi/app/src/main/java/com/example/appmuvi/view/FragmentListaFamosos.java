package com.example.appmuvi.view;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appmuvi.model.Pelicula;
import com.example.appmuvi.utils.ListenerPelicula;
import com.example.appmuvi.R;
import com.example.appmuvi.controller.ControllerPelicula;
import com.example.appmuvi.model.Famoso;

import java.util.List;

public class FragmentListaFamosos extends Fragment implements AdapterFamoso.ListenerDelAdapter  {

    private RecyclerView recyclerView;
    private ListenerDeFragment listenerDelFragmento;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_famosos, container, false);

        recyclerView = view.findViewById(R.id.fragment_famoso_recycler);
        //crear el adapter
        final AdapterFamoso adapterFamoso = new AdapterFamoso(this);

        ControllerPelicula peliculaController = new ControllerPelicula();
       /* peliculaController.traePelicula(new ListenerPelicula<List<Pelicula>>() {
            @Override
            public void finish(List<Pelicula> result) {
                adapterFamoso.setFamosoList(result);
            }
        });*/

        //setearle el layout manager (
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        //setearle el adapter
        recyclerView.setAdapter(adapterFamoso);


        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listenerDelFragmento = (ListenerDeFragment) context;
    }


    @Override
    public void informarFamoso(Famoso famoso) {
        listenerDelFragmento.recibirFamoso(famoso);
    }

    public interface ListenerDeFragment {

        public void recibirFamoso(Famoso famoso);


    }
}


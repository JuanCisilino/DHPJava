package com.example.retrofit_ejercicio1parte2.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit_ejercicio1parte2.R;
import com.example.retrofit_ejercicio1parte2.model.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class AdapterPeliculas extends RecyclerView.Adapter<AdapterPeliculas.ViewHolderPeliculas> {


    private List<Pelicula> peliculaList;
    private ListenerDelAdapter listenerDelAdapter;


    public AdapterPeliculas(List<Pelicula> peliculaList) {
        this.peliculaList = new ArrayList<>();
    }

    public AdapterPeliculas(ListenerDelAdapter listenerDelAdapter){
        peliculaList = new ArrayList<>();
        this.listenerDelAdapter = listenerDelAdapter;
    }

    public void setPeliculaList(List<Pelicula> peliculaList){
        this.peliculaList = peliculaList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolderPeliculas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View vistaDeLaCelda = inflater.inflate(R.layout.celda_pelicula,parent,false);
        return new ViewHolderPeliculas(vistaDeLaCelda);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPeliculas holder, int position) {

        Pelicula peliculaMostrada = peliculaList.get(position);

        holder.cargarPelicula(peliculaMostrada);

    }

    @Override
    public int getItemCount() {
        return peliculaList.size();
    }

    public class ViewHolderPeliculas extends RecyclerView.ViewHolder{

        //los atributos son los componentes visuales de la celda
        private TextView textViewTitulo;
        private TextView textViewAnio;

        //en el constructor del view holder encontrabamos los componentes visuales
        //el item view era la vista inflada de la celda
        public ViewHolderPeliculas(@NonNull View itemView) {
            super(itemView);
            textViewTitulo = itemView.findViewById(R.id.celdaPelicula_titulo);
            textViewAnio = itemView.findViewById(R.id.celdaPelicula_anio);


        }

        //la celda va
        public void cargarPelicula(Pelicula pelicula){
            textViewTitulo.setText(pelicula.getTitle());
            textViewAnio.setText(pelicula.getEstreno().toString());
        }

    }

    public interface ListenerDelAdapter{
        public void informarPelicula(Pelicula pelicula);

    }

}

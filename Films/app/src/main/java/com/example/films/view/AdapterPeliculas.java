package com.example.films.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.films.R;
import com.example.films.model.Pelicula;

import java.util.List;

public class AdapterPeliculas extends RecyclerView.Adapter<AdapterPeliculas.ViewHolderPeliculas> {

    private List<Pelicula> listaDePeliculas;

    public AdapterPeliculas(List<Pelicula> listaDePeliculas) {
        this.listaDePeliculas = listaDePeliculas;
    }

    @NonNull
    @Override
    public ViewHolderPeliculas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View vistaDeLaCelda = layoutInflater.inflate(R.layout.celda_pelicula,parent,false);

        ViewHolderPeliculas viewHolderPeliculas = new ViewHolderPeliculas(vistaDeLaCelda);

        return viewHolderPeliculas;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPeliculas holder, int position) {

        Pelicula peliculaAMostrar = listaDePeliculas.get(position);
        holder.cargarPelicula(peliculaAMostrar);

    }

    @Override
    public int getItemCount() {
        return listaDePeliculas.size();
    }

    public class ViewHolderPeliculas extends RecyclerView.ViewHolder{

        private TextView textViewTitulo, textViewDirector, textViewFecha;

        public ViewHolderPeliculas(@NonNull View itemView) {
            super(itemView);

            textViewTitulo = itemView.findViewById(R.id.celda_pelicula_titulo);
            textViewDirector = itemView.findViewById(R.id.celda_pelicula_director);
            textViewFecha = itemView.findViewById(R.id.celda_pelicula_fecha);

        }

        public void cargarPelicula(Pelicula pelicula){

            textViewTitulo.setText(pelicula.getTitulo());
            textViewDirector.setText(pelicula.getDirector());
            textViewFecha.setText(pelicula.getFechaDeEstreno());

        }
    }



}

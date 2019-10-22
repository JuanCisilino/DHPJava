package com.example.appmuvi.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmuvi.R;
import com.example.appmuvi.model.Famoso;
import com.example.appmuvi.model.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class AdapterPeliculas extends RecyclerView.Adapter<AdapterPeliculas.ViewHolderPeliculas> {

    private List<Pelicula> peliculaList;
    private ListenerDelAdapter listenerDelAdapter;

    public AdapterPeliculas(List<Pelicula> peliculaList) {
        this.peliculaList = peliculaList;
    }

    public AdapterPeliculas(ListenerDelAdapter listenerDelAdapter){
        peliculaList = new ArrayList<>();
        this.listenerDelAdapter = listenerDelAdapter;
    }

    public void setPeliculaList(List<Pelicula> peliculaList) {
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

        private TextView textViewTitulo, textViewDirector, textViewFechaDeLanzamiento;
        private ImageView imagenDePelicula;

        //constructor del view holder
        public ViewHolderPeliculas(@NonNull View itemView) {
            //EL ITEMVIEW ES LA CELDA DE LA LISTA
            super(itemView);
            //en la vista de la celda encuentro todos los componentes
            imagenDePelicula = itemView.findViewById(R.id.celda_peliculas_imageview);
            textViewTitulo = itemView.findViewById(R.id.celda_pelicula_Titulo);
            textViewDirector = itemView.findViewById(R.id.celda_pelicula_Director);
            textViewFechaDeLanzamiento = itemView.findViewById(R.id.celda_pelicula_FechadeLanzamiento);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Pelicula peliculaSeleccionada = peliculaList.get(getAdapterPosition());
                    listenerDelAdapter.informarPelicula(peliculaSeleccionada);
                }
            });


        }

        //metodo que le enseña al view holder a cargar un objeto en este caso el villano
        public void cargarPelicula(Pelicula pelicula){
            imagenDePelicula.setImageResource(pelicula.getImagenDePelicula());
            textViewTitulo.setText(pelicula.getTitulo());
            textViewDirector.setText(pelicula.getDirector());
            textViewFechaDeLanzamiento.setText(pelicula.getFechaDeEstreno());

        }

    }

    public interface ListenerDelAdapter {
        public void informarPelicula(Pelicula pelicula);
    }
}

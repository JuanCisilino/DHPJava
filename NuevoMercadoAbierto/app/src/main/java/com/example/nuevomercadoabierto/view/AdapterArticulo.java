package com.example.nuevomercadoabierto.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nuevomercadoabierto.R;
import com.example.nuevomercadoabierto.model.Articulo;

import java.util.ArrayList;
import java.util.List;

public class AdapterArticulo extends RecyclerView.Adapter<AdapterArticulo.ViewHolderArticulos> {

    private List<Articulo> articuloList;
    private ListenerDeAdapter listener;


    public AdapterArticulo(List<Articulo>articuloList) {
        this.articuloList = articuloList;
    }
    public AdapterArticulo(ListenerDeAdapter listener){
        articuloList = new ArrayList<>();
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolderArticulos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View vistaDeLaCelda = layoutInflater.inflate(R.layout.celda_articulo,parent,false);
        return new ViewHolderArticulos(vistaDeLaCelda);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderArticulos holder, int position) {
        Articulo articuloAMostrar = articuloList.get(position);
        holder.cargarArticulo(articuloAMostrar);
    }

    @Override
    public int getItemCount() {
        return articuloList.size();
    }

    public void setArticuloList(List<Articulo> articuloList) {
        this.articuloList = articuloList;
        notifyDataSetChanged();
    }

    public void agregarArticulo(Articulo articulo){
        articuloList.add(articulo);
        notifyDataSetChanged();
    }

    public class ViewHolderArticulos extends RecyclerView.ViewHolder{

        private TextView textViewNombreArticulo, textViewPrecio;
        private ImageView imagenDeArticulo;

        //constructor del view holder
        public ViewHolderArticulos(@NonNull View itemView) {
            //EL ITEMVIEW ES LA CELDA DE LA LISTA
            super(itemView);
            //en la vista de la celda encuentro todos los componentes
            imagenDeArticulo = itemView.findViewById(R.id.imagen_celda_articulo);
            textViewNombreArticulo = itemView.findViewById(R.id.textView_nombre_articulo);
            textViewPrecio = itemView.findViewById(R.id.textView_precio_articulo);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Articulo articuloSeleccionado = articuloList.get(getAdapterPosition());
                    listener.informarArticuloSeleccionado(articuloSeleccionado);
                }
            });


        }

        //metodo que le enseña al view holder a cargar un objeto en este caso el villano
        public void cargarArticulo(Articulo articulo){
            imagenDeArticulo.setImageResource(articulo.getImagenDeArticulo());
            textViewNombreArticulo.setText(articulo.getNombreDeArticulo());
            textViewPrecio.setText(articulo.getPrecioDeArticulo());

        }

    }

    public interface ListenerDeAdapter{
        public void informarArticuloSeleccionado(Articulo articulo);
    }

}

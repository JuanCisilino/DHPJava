package com.example.mercadoabierto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ArticuloAdapter extends RecyclerView.Adapter<ArticuloAdapter.ViewHolderArticulo> {

    private List<Articulo> listaDeArticulos;

    public ArticuloAdapter(List<Articulo> listaDeArticulos) {
        this.listaDeArticulos = listaDeArticulos;
    }


    @NonNull
    @Override
    public ViewHolderArticulo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View vistaDeLaCelda = layoutInflater.inflate(R.layout.celda_articulo,parent,false);

        ViewHolderArticulo viewHolderArticulo = new ViewHolderArticulo(vistaDeLaCelda);


        return viewHolderArticulo;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderArticulo holder, int position) {

        Articulo articuloAMostrar = listaDeArticulos.get(position);
        holder.cargarArticulo(articuloAMostrar);

    }

    @Override
    public int getItemCount() {
        return listaDeArticulos.size();
    }

    public class ViewHolderArticulo extends RecyclerView.ViewHolder{

        private TextView textViewNombreArticulo, textViewPrecio, textViewDescripcion;
        private ImageView imagenDeArticulo;

        //constructor del view holder
        public ViewHolderArticulo(@NonNull View itemView) {
            //EL ITEMVIEW ES LA CELDA DE LA LISTA
            super(itemView);
            //en la vista de la celda encuentro todos los componentes
            imagenDeArticulo = itemView.findViewById(R.id.imagen_celda_articulo);
            textViewNombreArticulo = itemView.findViewById(R.id.textView_nombre_articulo);
            textViewPrecio = itemView.findViewById(R.id.textView_precio_articulo);
            textViewDescripcion = itemView.findViewById(R.id.textView_descripcion_articulo);

        }

        //metodo que le enseña al view holder a cargar un objeto en este caso el villano
        public void cargarArticulo(Articulo articulo){
            imagenDeArticulo.setImageResource(articulo.getImagenDeArticulo());
            textViewNombreArticulo.setText(articulo.getNombreDeArticulo());
            textViewPrecio.setText(articulo.getPrecioDeArticulo());
            textViewDescripcion.setText(articulo.getDescripcionDeArticulo());
        }

        public void agregarArticulo(Articulo articulo){
            listaDeArticulos.add(new Articulo(articulo.getNombreDeArticulo(), articulo.getPrecioDeArticulo(),
                    articulo.getDescripcionDeArticulo(), R.drawable.ic_launcher_foreground));
        }
    }


}

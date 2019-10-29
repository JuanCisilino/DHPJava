package com.example.retrofit_ejercicio2.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit_ejercicio2.R;
import com.example.retrofit_ejercicio2.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class AdapterProductos extends RecyclerView.Adapter<AdapterProductos.ViewHolderArticulos> {

    private List<Producto> productoList;
    private ListenerDeAdapter listener;

    public AdapterProductos(List<Producto> productoList) {
        this.productoList = productoList;
    }

    public AdapterProductos(ListenerDeAdapter listener) {
        this.listener = listener;
        productoList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolderArticulos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View vistaDeLaCelda = layoutInflater.inflate(R.layout.celda_producto,parent,false);
        return new ViewHolderArticulos(vistaDeLaCelda);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderArticulos holder, int position) {
        Producto productoAMostrar = productoList.get(position);
        holder.cargarProducto(productoAMostrar);
    }

    @Override
    public int getItemCount() {
        return productoList.size();
    }

    public void setProductoList(List<Producto> productoList){
        this.productoList = productoList;
        notifyDataSetChanged();
    }

    public void agregarProducto(Producto producto){
        productoList.add(producto);
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
            imagenDeArticulo = itemView.findViewById(R.id.imagen_celda_producto);
            textViewNombreArticulo = itemView.findViewById(R.id.textView_nombre_producto);
            textViewPrecio = itemView.findViewById(R.id.textView_precio_producto);


        }

        //metodo que le enseña al view holder a cargar un objeto en este caso el villano
        public void cargarProducto(Producto producto){
            imagenDeArticulo.setImageResource(Integer.parseInt(producto.getFoto()));
            textViewNombreArticulo.setText(producto.getTitle());
            textViewPrecio.setText(producto.getPrice().toString());

        }

    }

    public interface ListenerDeAdapter{
        public void informarConsulta(Producto producto);
    }

}

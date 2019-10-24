package com.example.a24deoctubre.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class AdapterFamosos extends RecyclerView.Adapter<AdapterFamoso.ViewHolderFamoso> {

    private List<Famoso> famosoList;
    private ListenerDelAdapter listenerDelAdapter;

    public AdapterFamoso(List<Famoso> famosoList) {
        this.famosoList = famosoList;
    }

    public AdapterFamoso(ListenerDelAdapter listenerDelAdapter){
        famosoList = new ArrayList<>();
        this.listenerDelAdapter = listenerDelAdapter;
    }

    public void setFamosoList(List<Famoso> famosoList) {
        this.famosoList = famosoList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AdapterFamoso.ViewHolderFamoso onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View vistaDeLaCelda = inflater.inflate(R.layout.celda_famoso,parent,false);
        return new AdapterFamoso.ViewHolderFamoso(vistaDeLaCelda);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFamoso holder, int position) {
        Famoso famosoAMostrar = famosoList.get(position);
        holder.cargarFamoso(famosoAMostrar);
    }

    @Override
    public int getItemCount() {return famosoList.size();}

    public class ViewHolderFamoso extends RecyclerView.ViewHolder{

        private TextView nombre, nacimiento;
        private ImageView imagenFamoso;

        //constructor del view holder
        public ViewHolderFamoso(@NonNull View itemView) {
            //EL ITEMVIEW ES LA CELDA DE LA LISTA
            super(itemView);
            //en la vista de la celda encuentro todos los componentes
            imagenFamoso = itemView.findViewById(R.id.celda_famosos_imagen);
            nombre = itemView.findViewById(R.id.celda_famosos_nombre);
            nacimiento = itemView.findViewById(R.id.celda_famosos_fechaDeNacimiento);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Famoso famosoSeleccionado = famosoList.get(getAdapterPosition());
                    listenerDelAdapter.informarFamoso(famosoSeleccionado);
                }
            });


        }

        //metodo que le enseña al view holder a cargar un objeto en este caso el villano
        public void cargarFamoso(Famoso famoso){
            Glide.with(imagenFamoso.getContext()).load(famoso.generaURLImagen()).into(imagenFamoso);
            nombre.setText(famoso.getNombre());
            nacimiento.setText(famoso.getNacimiento());

        }

    }

    public interface ListenerDelAdapter {
        public void informarFamoso(Famoso famoso);
    }
}

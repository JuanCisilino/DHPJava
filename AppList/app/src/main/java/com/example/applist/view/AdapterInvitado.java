package com.example.applist.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applist.R;
import com.example.applist.model.Invitado;

import java.util.ArrayList;
import java.util.List;

public class AdapterInvitado extends RecyclerView.Adapter<AdapterInvitado.ViewHolderInvitados> {

    private List<Invitado> invitadoList;
    private ListenerDelAdapter listenerDelAdapter;

    public AdapterInvitado(List<Invitado> invitadoList) {
        this.invitadoList = invitadoList;
    }

    public AdapterInvitado(ListenerDelAdapter listenerDelAdapter){
        invitadoList = new ArrayList<>();
        this.listenerDelAdapter = listenerDelAdapter;
    }


    @NonNull
    @Override
    public ViewHolderInvitados onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View vistaDeLaCelda = inflater.inflate(R.layout.celda_invitado,parent,false);
        return new ViewHolderInvitados(vistaDeLaCelda);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderInvitados holder, int position) {
        Invitado invitadoAMostrar = invitadoList.get(position);
        holder.cargarInvitado(invitadoAMostrar);
    }

    @Override
    public int getItemCount() {
        return invitadoList.size();
    }

    public void setInvitadoList(List<Invitado> invitadoList) {
        this.invitadoList = invitadoList;
        notifyDataSetChanged();
    }


    public class ViewHolderInvitados extends RecyclerView.ViewHolder{

        //los atributos son los componentes visuales de la celda
        private TextView textViewNombre;
        private TextView textViewApellido;


        //en el constructor del view holder encontrabamos los componentes visuales
        //el item view era la vista inflada de la celda
        public ViewHolderInvitados(@NonNull View itemView) {
            super(itemView);
            textViewNombre = itemView.findViewById(R.id.textView_Nombre);
            textViewApellido = itemView.findViewById(R.id.textView_Apellido);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Invitado invitadoSeleccionado = invitadoList.get(getAdapterPosition());
                    listenerDelAdapter.informarInvitadoSeleccionada(invitadoSeleccionado);
                }
            });
        }

        //la celda va
        public void cargarInvitado(Invitado invitado){
            textViewNombre.setText(invitado.getNombre());
            textViewApellido.setText(invitado.getApellido());
        }

    }

    public interface ListenerDelAdapter{
        public void informarInvitadoSeleccionada(Invitado invitado);
    }

}

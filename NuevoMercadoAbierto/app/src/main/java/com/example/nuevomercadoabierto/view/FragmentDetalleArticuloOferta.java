package com.example.nuevomercadoabierto.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.nuevomercadoabierto.R;
import com.example.nuevomercadoabierto.model.Articulo;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetalleArticuloOferta extends Fragment {

    public static final String CLAVE_ARTICULO_OFERTA = "claveArticuloOferta";

    private TextView textViewNombreArticulo, textViewPrecio;

    private ImageView imageViewImagenArticuloOferta;

    public static FragmentDetalleArticuloOferta dameUnFragment(Articulo articulo){

        FragmentDetalleArticuloOferta fragmentDetalleArticuloOferta = new FragmentDetalleArticuloOferta();

        Bundle bundle = new Bundle();
        bundle.putSerializable(CLAVE_ARTICULO_OFERTA, articulo);
        fragmentDetalleArticuloOferta.setArguments(bundle);

        return fragmentDetalleArticuloOferta;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle_articulo_oferta, container, false);

        textViewNombreArticulo = view.findViewById(R.id.fragment_ArticuloOferta_Titulo);
        textViewPrecio = view.findViewById(R.id.fragment_ArticuloOferta_Precio);
        imageViewImagenArticuloOferta = view.findViewById(R.id.fragment_imagenArticuloOferta);

        Bundle bundle = getArguments();

        Articulo articulo = (Articulo) bundle.getSerializable(CLAVE_ARTICULO_OFERTA);

        textViewNombreArticulo.setText(articulo.getNombreDeArticulo());
        textViewPrecio.setText(articulo.getPrecioDeArticulo());

        Glide.with(getContext())
                .load(articulo.getImagenurl())
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .into(imageViewImagenArticuloOferta);

        return view;
    }

}

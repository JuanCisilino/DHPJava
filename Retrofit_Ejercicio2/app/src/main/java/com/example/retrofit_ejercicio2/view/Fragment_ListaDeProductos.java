package com.example.retrofit_ejercicio2.view;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.retrofit_ejercicio2.R;
import com.example.retrofit_ejercicio2.controller.ControlerProducto;
import com.example.retrofit_ejercicio2.model.Producto;
import com.example.retrofit_ejercicio2.model.ProductosDao;
import com.example.retrofit_ejercicio2.utils.ResultListener;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */

public class Fragment_ListaDeProductos extends Fragment implements AdapterProductos.ListenerDeAdapter{

    private Button botonConsulta;
    private RecyclerView recyclerView;
    private ListenerDeFragment listenerDeFragment;
    private EditText consulta;


    Bundle bundle = new Bundle();
    AdapterProductos adapterProductos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__lista_de_productos, container, false);

        botonConsulta = view.findViewById(R.id.boton_Consulta_fragmentLista);
        recyclerView = view.findViewById(R.id.contenedor_recycler_fragmentLista);
        consulta = view.findViewById(R.id.editText_fragmentLista);

        adapterProductos = new AdapterProductos(this);
        final ControlerProducto controlerProducto = new ControlerProducto();

        botonConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString(ProductosDao.PRODUCTOSELECCIONADO, consulta.getText().toString());
                controlerProducto.traerProductos(new ResultListener<List<Producto>>() {
                    @Override
                    public void finish(List<Producto> result) {
                        adapterProductos.setProductoList(result);
                    }
                });

            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),
                RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(adapterProductos);

        return view;
    }

    @Override
    public void informarConsulta(Producto producto) {

    }

    public interface ListenerDeFragment {
        public void recibirConsulta(Producto producto);

    }
}

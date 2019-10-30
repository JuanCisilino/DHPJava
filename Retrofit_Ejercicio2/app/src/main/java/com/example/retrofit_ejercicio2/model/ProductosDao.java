package com.example.retrofit_ejercicio2.model;

import com.example.retrofit_ejercicio2.utils.ResultListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductosDao extends RetrofitProductosDao {

    public static final String BASE_URL = "https://api.mercadolibre.com/sites/MLA/";
    public static final String PRODUCTOSELECCIONADO = "Producto";


    public ProductosDao() {
        super(BASE_URL);
    }

    public void traerPruductos(final ResultListener<List<Producto>> listenerDelControler) {

        Call<ContenedorProducto> call = serviceProducto.traeListadePoducto(PRODUCTOSELECCIONADO);

        call.enqueue(new Callback<ContenedorProducto>() {
            @Override
            public void onResponse(Call<ContenedorProducto> call, Response<ContenedorProducto> response) {
                ContenedorProducto contenedorProducto = response.body();
                listenerDelControler.finish(contenedorProducto.getResults());
            }

            @Override
            public void onFailure(Call<ContenedorProducto> call, Throwable t) {

            }
        });

    }
}

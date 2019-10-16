package com.example.nuevomercadoabierto.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toast;

import com.example.nuevomercadoabierto.R;
import com.example.nuevomercadoabierto.model.Articulo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements FragmentListaDeArticulos.ListenerDeFragment, FragmentAgregarArticulo.ListerDeAgregarArticulo {

   private FragmentListaDeArticulos fragmentListaDeArticulos;
   private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentListaDeArticulos = new FragmentListaDeArticulos();
        viewPager = findViewById(R.id.mainActivity_viewPagercontainer);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),crearLista());
        viewPager.setAdapter(viewPagerAdapter);
        pegarFragment(fragmentListaDeArticulos);
    }


    private void pegarFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.mainActivity_container, fragment)
                .addToBackStack(null)
                .commit();
    }



    @Override
    public void recibirArticulo(Articulo articulo) {
        //aca voy a cargar el fragmetn con el detalle del articulo
        Toast.makeText(this, articulo.getNombreDeArticulo(), Toast.LENGTH_SHORT).show();
        FragmentDescripcionDelArticulo fragmentDescripcionDelArticulo = new FragmentDescripcionDelArticulo();
        Bundle bundle = new Bundle();
        bundle.putSerializable(fragmentDescripcionDelArticulo.CLAVE_ARTICULO,articulo);
        fragmentDescripcionDelArticulo.setArguments(bundle);
        pegarFragment(fragmentDescripcionDelArticulo);
    }

    @Override
    public void recibirBoton() {
        pegarFragment(new FragmentAgregarArticulo());

    }


    @Override
    public void agregararticulo(Articulo articulo) {
        fragmentListaDeArticulos.agregarArticuo(articulo);
        onBackPressed();
    }

    private List<Articulo> crearLista(){
        List<Articulo> listaArticulosDeOferta = new ArrayList<>();

        listaArticulosDeOferta.add(new Articulo("Fideos","$24",
                "Aprovechalo sin IVA", "https://www.expogourmetmagazine.com/uploads/fotos_noticias/2016/03/12510-103478.jpg"));
        listaArticulosDeOferta.add(new Articulo("Arroz","$20",
                "Aprovechalo sin IVA", "https://yerbamanda.com.ar/wp-content/uploads/2017/06/2017-06-15-vitrina_arroz.png"));
        listaArticulosDeOferta.add(new Articulo("Cafe","$149",
                "Aprovechalo sin IVA","https://www.staples.com.ar/images/300/CAFNCCL170.jpg"));
        listaArticulosDeOferta.add(new Articulo("Harina Pan","$128",
                "Aprovechalo sin IVA", "https://commons.wikimedia.org/wiki/File:Paquete_de_Harina_PAN.jpg"));
        listaArticulosDeOferta.add(new Articulo("Ravioles","$35",
                "Aprovechalo sin IVA", "https://en.wikipedia.org/wiki/Ravioli#/media/File:Flickr_-_cyclonebill_-_Ravioli_med_skinke_og_asparges_i_mascarponecreme.jpg"));
        listaArticulosDeOferta.add(new Articulo("Agnelotis", "$56",
                "Aprovechalo sin IVA","http://3.bp.blogspot.com/_mNmRwPWl31Q/SIXwzibtAEI/AAAAAAAABYo/tcZwDGy8MHw/s400/a%C3%B1olotis13.JPG"));

        return listaArticulosDeOferta;

    }
}

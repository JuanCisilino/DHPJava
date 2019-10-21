package com.example.appmuvi.model;

import com.example.appmuvi.utils.ListenerPelicula;
import com.example.appmuvi.R;

import java.util.ArrayList;
import java.util.List;

public class FamososDAO {

    private static final String BASE_URL = "https://api.themoviedb.org";

    public static final String NOMBRE = "Nombre", NACIMIENTO = "Fecha de Nacimiento";

    List<Famoso> famosoList = new ArrayList<>();


   /* public void traerFamoso(ListenerPelicula<List<Famoso>> listListenerPelicula) {

        famosoList.add(new Famoso("Brad Pit","18/4/75", R.drawable.logomuviapp));
        famosoList.add(new Famoso("Brad Pit","18/4/75",R.drawable.logomuviapp));
        famosoList.add(new Famoso("Brad Pit","18/4/75",R.drawable.logomuviapp));
        famosoList.add(new Famoso("Brad Pit","18/4/75",R.drawable.logomuviapp));
        famosoList.add(new Famoso("Brad Pit","18/4/75",R.drawable.logomuviapp));
        famosoList.add(new Famoso("Brad Pit","18/4/75",R.drawable.logomuviapp));
        famosoList.add(new Famoso("Brad Pit","18/4/75",R.drawable.logomuviapp));
        famosoList.add(new Famoso("Brad Pit","18/4/75",R.drawable.logomuviapp));
        famosoList.add(new Famoso("Brad Pit","18/4/75",R.drawable.logomuviapp));
        famosoList.add(new Famoso("Brad Pit","18/4/75",R.drawable.logomuviapp));


        listListenerPelicula.finish(famosoList);


    }*/
}

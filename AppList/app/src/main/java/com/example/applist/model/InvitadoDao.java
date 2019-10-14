package com.example.applist.model;

import com.example.applist.ResultListener;

import java.util.ArrayList;
import java.util.List;

public class InvitadoDao {

    List<Invitado> invitados = new ArrayList<>();

    public void traerInvitados(ResultListener<List<Invitado>> resultListener) {

        invitados.add(new Invitado("Juan", "Cisilino"));
        invitados.add(new Invitado("Nicolas", "Cisilino"));
        invitados.add(new Invitado("Cheryl", "De Los Reyes Cruz"));
        invitados.add(new Invitado("Luisa", "Chorostecki"));
        invitados.add(new Invitado("Juan", "Cisilino"));
        invitados.add(new Invitado("Nicolas", "Cisilino"));
        invitados.add(new Invitado("Cheryl", "De Los Reyes Cruz"));
        invitados.add(new Invitado("Luisa", "Chorostecki"));
        invitados.add(new Invitado("Juan", "Cisilino"));
        invitados.add(new Invitado("Nicolas", "Cisilino"));
        invitados.add(new Invitado("Cheryl", "De Los Reyes Cruz"));
        invitados.add(new Invitado("Luisa", "Chorostecki"));
        invitados.add(new Invitado("Juan", "Cisilino"));
        invitados.add(new Invitado("Nicolas", "Cisilino"));
        invitados.add(new Invitado("Cheryl", "De Los Reyes Cruz"));
        invitados.add(new Invitado("Luisa", "Chorostecki"));
        invitados.add(new Invitado("Juan", "Cisilino"));
        invitados.add(new Invitado("Nicolas", "Cisilino"));
        invitados.add(new Invitado("Cheryl", "De Los Reyes Cruz"));
        invitados.add(new Invitado("Luisa", "Chorostecki"));
        invitados.add(new Invitado("Juan", "Cisilino"));
        invitados.add(new Invitado("Nicolas", "Cisilino"));
        invitados.add(new Invitado("Cheryl", "De Los Reyes Cruz"));
        invitados.add(new Invitado("Luisa", "Chorostecki"));

        resultListener.finish(invitados);
    }
}

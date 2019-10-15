package com.example.applist.controller;

import com.example.applist.ResultListener;
import com.example.applist.model.Invitado;
import com.example.applist.model.InvitadoDao;

import java.util.List;

public class ControllerInvitado {

    public void traerinvitados(final ResultListener listenerDeLaVista){
        InvitadoDao invititadoDao = new InvitadoDao();
        invititadoDao.traerInvitados(new ResultListener<List<Invitado>>() {
            @Override
            public void finish(List<Invitado> result) {
                listenerDeLaVista.finish(result);
            }
        });
    }
}

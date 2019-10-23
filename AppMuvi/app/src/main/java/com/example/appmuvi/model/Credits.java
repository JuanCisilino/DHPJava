package com.example.appmuvi.model;

import java.util.List;

public class Credits {

    private Integer id;
    private List<Persona> cast;
    private List<Persona> crew;

    public Credits(Integer id, List<Persona> cast, List<Persona> crew) {
        this.id = id;
        this.cast = cast;
        this.crew = crew;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Persona> getCast() {
        return cast;
    }

    public void setCast(List<Persona> cast) {
        this.cast = cast;
    }

    public List<Persona> getCrew() {
        return crew;
    }

    public void setCrew(List<Persona> crew) {
        this.crew = crew;
    }
}




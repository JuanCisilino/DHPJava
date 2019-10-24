package com.example.appmuvi.model;

import java.util.List;

public class Credits {

    private Integer id;
    private List<Persona> cast;
    private List<Persona> crew;

    private String birthday;
    private String biography;
    private String place_of_birth;

    public Credits(Integer id, List<Persona> cast, List<Persona> crew, String birthday,
                   String biography, String place_of_birth) {
        this.id = id;
        this.cast = cast;
        this.crew = crew;
        this.biography = biography;
        this.birthday = birthday;
        this.place_of_birth = place_of_birth;

    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public void setPlace_of_birth(String place_of_birth) {
        this.place_of_birth = place_of_birth;
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




package com.example.films.model;

import java.util.ArrayList;
import java.util.List;

public class PeliculaDao {

    public List<Pelicula> traerPeliculas() {

        List<Pelicula> peliculas = new ArrayList<>();

        peliculas.add(new Pelicula("A New Hope", "27-07-03", "George Lucas"));
        peliculas.add(new Pelicula("Revenge of the Siths", "17-07-93", "George Lucas"));
        peliculas.add(new Pelicula("Superbad", "7-07-83", "George Lucas"));
        peliculas.add(new Pelicula("Aguante Skywalker", "37-06-73", "George Lucas"));
        peliculas.add(new Pelicula("Vader el mas capo", "37-05-63", "George Lucas"));
        peliculas.add(new Pelicula("A New Hope", "37-04-03", "George Lucas"));
        peliculas.add(new Pelicula("Revenge of the Siths", "37-03-93", "George Lucas"));
        peliculas.add(new Pelicula("Superbad", "37-02-83", "George Lucas"));
        peliculas.add(new Pelicula("Aguante Skywalker", "14-07-73", "George Lucas"));
        peliculas.add(new Pelicula("Vader el mas capo", "23-07-63", "George Lucas"));
        peliculas.add(new Pelicula("A New Hope", "25-07-03", "George Lucas"));
        peliculas.add(new Pelicula("Revenge of the Siths", "11-07-93", "George Lucas"));
        peliculas.add(new Pelicula("Superbad", "16-07-83", "George Lucas"));
        peliculas.add(new Pelicula("Aguante Skywalker", "21-07-73", "George Lucas"));
        peliculas.add(new Pelicula("Vader el mas capo", "28-07-63", "George Lucas"));

        return peliculas;
    }

}

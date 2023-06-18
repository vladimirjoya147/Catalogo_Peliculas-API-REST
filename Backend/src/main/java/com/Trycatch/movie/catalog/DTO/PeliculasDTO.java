package com.Trycatch.movie.catalog.DTO;

import com.Trycatch.movie.catalog.Entidad.GeneroPelicula;

import java.util.List;

public record PeliculasDTO(
        Integer id,
        String titulo,
        List<GeneroPelicula> generos,
        DatosDirector director,
        Integer year,
        String duracion,
        float calificacion,
        String sypnosis,
        String rutaportada
) {

}

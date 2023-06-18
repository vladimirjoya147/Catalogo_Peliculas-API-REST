package com.Trycatch.movie.catalog.DTO;

import jakarta.persistence.criteria.CriteriaBuilder;

import java.time.LocalDateTime;

public record FavoritoRespondeDTO (
        Integer id,
        String nombreUsuario,
        String tituloPelicula
){
}

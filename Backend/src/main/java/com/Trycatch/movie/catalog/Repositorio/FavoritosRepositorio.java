package com.Trycatch.movie.catalog.Repositorio;

import com.Trycatch.movie.catalog.Entidad.Favoritos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoritosRepositorio extends JpaRepository<Favoritos, Integer> {
}

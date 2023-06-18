package com.Trycatch.movie.catalog.Repositorio;

import com.Trycatch.movie.catalog.Entidad.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentariosRepositorio extends JpaRepository<Comentarios, Integer> {
}

package com.Trycatch.movie.catalog.Repositorio;

import com.Trycatch.movie.catalog.Entidad.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepositorio extends JpaRepository<Director, Integer> {
}

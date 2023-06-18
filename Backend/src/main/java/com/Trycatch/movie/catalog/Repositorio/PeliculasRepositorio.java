package com.Trycatch.movie.catalog.Repositorio;

import com.Trycatch.movie.catalog.Entidad.Peliculas;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculasRepositorio extends JpaRepository<Peliculas, Integer> {

    @Query("SELECT p FROM Peliculas p WHERE p.titulo LIKE %:nombre%")
    List<Peliculas> buscarPorNombre(@Param("nombre") String nombre);
}

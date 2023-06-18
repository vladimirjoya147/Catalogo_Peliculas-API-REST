package com.Trycatch.movie.catalog.Servicio;

import com.Trycatch.movie.catalog.Entidad.Peliculas;
import com.Trycatch.movie.catalog.Entidad.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PeliculasServicio {

    List<Peliculas> buscarPeliculaPorNombre(String nombre);

    public Page<Peliculas> listapeliculas(Pageable pageable);

    public Peliculas obtenerPeliculaPorId(Integer id);
    
    public Peliculas guardarPeliculas(Peliculas peliculas);
    
    public void eliminarPeliculaId(Integer id);
    
    public Peliculas actualizarPelicula(Peliculas peliculas);

    public Usuario almacenarUsuario(Usuario usuario);

    public Usuario buscarUsuarioPorId(Long id);

    public void eliminarUsuarioId(Long id);


}

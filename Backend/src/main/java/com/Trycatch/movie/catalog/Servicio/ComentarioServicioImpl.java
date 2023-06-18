package com.Trycatch.movie.catalog.Servicio;

import com.Trycatch.movie.catalog.Entidad.Comentarios;
import com.Trycatch.movie.catalog.Entidad.Favoritos;
import com.Trycatch.movie.catalog.Repositorio.ComentariosRepositorio;
import com.Trycatch.movie.catalog.Repositorio.FavoritosRepositorio;
import org.springframework.stereotype.Service;

@Service
public class ComentarioServicioImpl implements ComentarioServicio{

    private final ComentariosRepositorio repositorio;
    private final FavoritosRepositorio favoritosRepositorio;
    public ComentarioServicioImpl (ComentariosRepositorio comentariosRepositorio,
                                   FavoritosRepositorio favoritosRepositorio){
        this.repositorio=comentariosRepositorio;
        this.favoritosRepositorio=favoritosRepositorio;
    }
    @Override
    public Comentarios guardarComentario(Comentarios comentario) {
        return repositorio.save(comentario);
    }

    @Override
    public Favoritos guardarFavoritos(Favoritos favoritos) {
        return favoritosRepositorio.save(favoritos);
    }
}

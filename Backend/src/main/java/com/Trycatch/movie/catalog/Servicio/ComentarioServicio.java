package com.Trycatch.movie.catalog.Servicio;

import com.Trycatch.movie.catalog.Entidad.Comentarios;
import com.Trycatch.movie.catalog.Entidad.Favoritos;
import org.springframework.http.ResponseEntity;

public interface ComentarioServicio {

    public Comentarios guardarComentario(Comentarios comentario);

    public Favoritos guardarFavoritos( Favoritos favoritos);
}

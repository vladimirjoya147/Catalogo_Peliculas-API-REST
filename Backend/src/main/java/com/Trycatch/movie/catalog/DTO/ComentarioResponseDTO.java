package com.Trycatch.movie.catalog.DTO;

import java.time.LocalDateTime;

public record ComentarioResponseDTO(
         String comentario,
         LocalDateTime fechaComentario,
        String nombreUsuario,
        String tituloPelicula
) {
}

package com.Trycatch.movie.catalog.Controller;

import com.Trycatch.movie.catalog.DTO.ComentarioResponseDTO;
import com.Trycatch.movie.catalog.Entidad.Comentarios;
import com.Trycatch.movie.catalog.Entidad.Peliculas;
import com.Trycatch.movie.catalog.Entidad.Usuario;
import com.Trycatch.movie.catalog.Servicio.ComentarioServicio;
import com.Trycatch.movie.catalog.Servicio.PeliculasServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ComentariosController {

    private final ComentarioServicio servicio;
    private final PeliculasServicio peliculasServicio;


    public ComentariosController(ComentarioServicio servicio,
                                 PeliculasServicio peliculasServicio) {
        this.servicio = servicio;
        this.peliculasServicio = peliculasServicio;
    }

    @PostMapping("/registrar/{peliculaId}/usuario/{usuarioId}")
    public ResponseEntity<ComentarioResponseDTO> registrarComentario(@RequestBody Comentarios comentarios,
                                                                     @PathVariable Integer peliculaId,
                                                                     @PathVariable Long usuarioId) {
        Peliculas peliculaExistente = peliculasServicio.obtenerPeliculaPorId(peliculaId);
        Usuario usuario = peliculasServicio.buscarUsuarioPorId(usuarioId);

        comentarios.setPelicula(peliculaExistente);
        comentarios.setUsuario(usuario);
        servicio.guardarComentario(comentarios);
        ComentarioResponseDTO responseDTO = new ComentarioResponseDTO(comentarios.getComentario(),
                comentarios.getFechaComentario(),usuario.getNombreUsuario(),peliculaExistente.getTitulo());
        return ResponseEntity.ok(responseDTO);
    }
}


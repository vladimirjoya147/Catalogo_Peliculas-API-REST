package com.Trycatch.movie.catalog.Controller;

import com.Trycatch.movie.catalog.DTO.FavoritoRespondeDTO;
import com.Trycatch.movie.catalog.Entidad.Favoritos;
import com.Trycatch.movie.catalog.Entidad.Peliculas;
import com.Trycatch.movie.catalog.Entidad.Usuario;
import com.Trycatch.movie.catalog.Servicio.ComentarioServicio;
import com.Trycatch.movie.catalog.Servicio.PeliculasServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class FavoritosController {

    private final ComentarioServicio servicio;
    private final PeliculasServicio peliculasServicio;


    public FavoritosController(ComentarioServicio servicio,
                               PeliculasServicio peliculasServicio) {
        this.servicio = servicio;
        this.peliculasServicio = peliculasServicio;
    }

    @PostMapping("/favoritos/registrar/{peliculaId}/usuario/{usuarioId}")
    public ResponseEntity<FavoritoRespondeDTO> registrarFavoritos(@PathVariable Integer peliculaId,
                                                                  @PathVariable Long usuarioId) {
        Peliculas peliculaExistente = peliculasServicio.obtenerPeliculaPorId(peliculaId);
        Usuario usuario = peliculasServicio.buscarUsuarioPorId(usuarioId);

        Favoritos favoritos = new Favoritos();
        favoritos.setPelicula(peliculaExistente);
        favoritos.setUsuario(usuario);
        Favoritos favoritosGuardados = servicio.guardarFavoritos(favoritos);

        FavoritoRespondeDTO responseDTO = new FavoritoRespondeDTO(favoritosGuardados.getId(), usuario.getNombreUsuario(),
                peliculaExistente.getTitulo());
        return ResponseEntity.ok(responseDTO);
    }
}


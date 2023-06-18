package com.Trycatch.movie.catalog.Controller;


import com.Trycatch.movie.catalog.DTO.PeliculasDTO;
import com.Trycatch.movie.catalog.DTO.DatosDirector;
import com.Trycatch.movie.catalog.Entidad.Peliculas;
import com.Trycatch.movie.catalog.Servicio.PeliculasServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/movies")
public class PeliculasController {

    private final PeliculasServicio servicio;

    public PeliculasController(PeliculasServicio servicio){
        this.servicio=servicio;
    }

    @GetMapping
    public ResponseEntity<List<PeliculasDTO>> obtenerPeliculas(@RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "6") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Peliculas> peliculasPage = servicio.listapeliculas(pageable);

        if (peliculasPage.isEmpty()) {
            return ResponseEntity.notFound().header("mensaje", "No se encontraron películas").build();
        } else {
            List<Peliculas> peliculas = peliculasPage.getContent();
            List<PeliculasDTO> peliculasDTO = new ArrayList<>();

            for (Peliculas pelicula : peliculas) {
                peliculasDTO.add(new PeliculasDTO(pelicula.getId(), pelicula.getTitulo(), pelicula.getGeneros(),
                        new DatosDirector(pelicula.getDirector().getId(), pelicula.getDirector().getName()),
                        pelicula.getYear(), pelicula.getDuracion(), pelicula.getCalificacion(),
                        pelicula.getSypnosis(), pelicula.getRutaportada()));
            }

            return ResponseEntity.ok(peliculasDTO);
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<PeliculasDTO>> buscarPeliculaPorNombre(@RequestParam("nombre") String nombre) {
        List<Peliculas> peliculas = servicio.buscarPeliculaPorNombre(nombre);
        if (peliculas.isEmpty()) {
            String mensaje = "No se encontraron películas con el nombre: " + nombre;
            return ResponseEntity.notFound().header("Custom-Header", mensaje).build();
        } else {
            List<PeliculasDTO> peliculasDTO = new ArrayList<>();
            for (Peliculas pelicula : peliculas) {
                PeliculasDTO peliculaDTO = new PeliculasDTO(pelicula.getId(), pelicula.getTitulo(), pelicula.getGeneros(),
                        new DatosDirector(pelicula.getDirector().getId(), pelicula.getDirector().getName()),
                        pelicula.getYear(), pelicula.getDuracion(), pelicula.getCalificacion(), pelicula.getSypnosis(),
                        pelicula.getRutaportada());
                peliculasDTO.add(peliculaDTO);
            }
            return ResponseEntity.ok(peliculasDTO);
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<PeliculasDTO> obtenerpeliculasId(@PathVariable Integer id) {
        Peliculas pelicula = servicio.obtenerPeliculaPorId(id);
        if (pelicula == null){
            String mensaje = "La pelicula con el ID "+id+" no fue encontrado.";
            return ResponseEntity.notFound().header("Custom-Header",mensaje).build();
        }else{
            PeliculasDTO peliculaDTO = new PeliculasDTO(pelicula.getId(), pelicula.getTitulo(), pelicula.getGeneros(),
                    new DatosDirector(pelicula.getDirector().getId(), pelicula.getDirector().getName()),
                    pelicula.getYear(), pelicula.getDuracion(), pelicula.getCalificacion(), pelicula.getSypnosis(),
                    pelicula.getRutaportada());
            return ResponseEntity.ok(peliculaDTO);
        }
    }

    @PostMapping("/registrar")
    public ResponseEntity<Peliculas> regitrarPelicula(@RequestBody Peliculas peliculas) {
        Peliculas nuevapelicula = servicio.guardarPeliculas(peliculas);
        System.out.println("Pelicula registrada " + peliculas);
        return ResponseEntity.ok(nuevapelicula);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPelicula(@PathVariable Integer id){
        servicio.eliminarPeliculaId(id);
        return ResponseEntity.ok("Pelicula eliminada exitosamente");
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Peliculas> actualizapelicula(@PathVariable Integer id, @RequestBody Peliculas nuevapelicula){
        Peliculas peliculaExistente = servicio.obtenerPeliculaPorId(id);
        peliculaExistente.setId(id);
        peliculaExistente.setTitulo(nuevapelicula.getTitulo());
        peliculaExistente.setGeneros(nuevapelicula.getGeneros());
        peliculaExistente.setDirector(nuevapelicula.getDirector());
        peliculaExistente.setYear(nuevapelicula.getYear());
        peliculaExistente.setDuracion(nuevapelicula.getDuracion());
        peliculaExistente.setCalificacion(nuevapelicula.getCalificacion());
        peliculaExistente.setSypnosis(nuevapelicula.getSypnosis());
        peliculaExistente.setRutaportada(nuevapelicula.getRutaportada());
        Peliculas peliculaActualizada = servicio.actualizarPelicula(peliculaExistente);
        return ResponseEntity.ok(peliculaActualizada);
    }
}
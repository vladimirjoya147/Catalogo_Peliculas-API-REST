package com.Trycatch.movie.catalog.Entidad;

import jakarta.persistence.*;
import lombok.*;
@EqualsAndHashCode(of="id")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name="favoritos")
public class Favoritos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pelicula_id")
    private Peliculas pelicula;
}

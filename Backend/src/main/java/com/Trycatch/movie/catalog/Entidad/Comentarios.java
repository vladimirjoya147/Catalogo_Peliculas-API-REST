package com.Trycatch.movie.catalog.Entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;



@EqualsAndHashCode(of="id")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name="comentarios")
public class Comentarios {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @NotBlank
        @Column(name = "comentario")
        private String comentario;

        private LocalDateTime fechaComentario = LocalDateTime.now();

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "usuario_id")
        private Usuario usuario;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "pelicula_id")
        private Peliculas pelicula;

        public Comentarios(String comentario, LocalDateTime fechaComentario, Usuario usuario, Peliculas pelicula) {
                this.comentario = comentario;
                this.fechaComentario = fechaComentario;
                this.usuario = usuario;
                this.pelicula = pelicula;
        }

        @Override
        public String toString() {
                return "Comentarios{" +
                        "comentario='" + comentario + '\'' +
                        ", fechaComentario=" + fechaComentario +
                        ", usuario=" + usuario +
                        ", pelicula=" + pelicula +
                        '}';
        }
}
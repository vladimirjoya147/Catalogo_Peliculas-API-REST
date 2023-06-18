package com.Trycatch.movie.catalog.Entidad;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="peliculas")
@EqualsAndHashCode(of = "id")
@Data
public class Peliculas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pelicula_id")
    private Integer id;

    @NotBlank
    @Column(name="titulo")
    private String titulo;

    @ElementCollection(targetClass = GeneroPelicula.class)
    @CollectionTable(name = "peliculas_generos", joinColumns = @JoinColumn(name = "pelicula_id"))
    @Column(name = "generos")
    @Enumerated(EnumType.STRING)
    private List<GeneroPelicula> generos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Director director;

    @Max(value=2023, message = "debe ser menor o igual al 2023")
    @Column(name="anno_lanzamiento")
    private Integer year;

    @NotNull
    private String duracion;

    @Max(value=5, message = "la calificiacion maxima es 5")
    private float calificacion;

    @NotBlank
    private String sypnosis;

    @NotBlank
    private String rutaportada;


    @Override
    public String toString() {
        return "Peliculas{" +
                "titulo='" + titulo + '\'' +
                ", generos=" + generos +
                ", director=" + director +
                ", year=" + year +
                ", duracion='" + duracion + '\'' +
                ", calificacion=" + calificacion +
                ", sypnosis='" + sypnosis + '\'' +
                ", rutaportada='" + rutaportada + '\'' +
                '}';
    }

}

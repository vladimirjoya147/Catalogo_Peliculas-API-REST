package com.Trycatch.movie.catalog.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
@JsonIgnoreProperties("peliculas")
@Entity (name="peliculas_directores")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Column(name="nombre")
    private String name;

    @OneToMany(mappedBy = "director",fetch = FetchType.LAZY)
    private List<Peliculas> peliculas;

    public Director(String name) {
        this.name = name;
    }

    public Director(Integer id) {
        this.id = id;
    }

    public Director(String name, List<Peliculas> peliculas) {
        this.name = name;
        this.peliculas = peliculas;
    }

    @Override
    public String toString() {
        return "Director{" +
                "name='" + name + '\'' +
                '}';
    }
}

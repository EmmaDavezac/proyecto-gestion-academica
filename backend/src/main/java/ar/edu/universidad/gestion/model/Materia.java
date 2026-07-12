package ar.edu.universidad.gestion.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer nivel;
    @ManyToMany
    @JoinTable(
            name = "materia_profesor",
            joinColumns = @JoinColumn(name = "materia_id"),
            inverseJoinColumns = @JoinColumn(name = "profesor_id")
    )
    private Set<Profesor> profesores;
}
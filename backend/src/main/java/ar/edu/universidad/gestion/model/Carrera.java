package ar.edu.universidad.gestion.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private Integer duracion;

    @OneToMany(mappedBy = "carrera")
    private List<Estudiante> estudiantes;
}

package ar.edu.universidad.gestion.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cursada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer anio;
    private String estado; // Ejemplo: "APROBADO", "EN CURSO"
    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;
    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;
}
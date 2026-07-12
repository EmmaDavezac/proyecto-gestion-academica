package ar.edu.universidad.gestion.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Estudiante extends Persona {
    private String legajo;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "libreta_id") // Crea la columna FK en la tabla
    private LibretaUniversitaria libreta;

    @ManyToOne
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    @OneToMany(mappedBy = "estudiante")
    private List<Cursada> cursadas;

}


package ar.edu.universidad.gestion.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Profesor extends Persona {
    private String titulo;
    private Double sueldo;
}
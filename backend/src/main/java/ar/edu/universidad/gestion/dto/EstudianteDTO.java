package ar.edu.universidad.gestion.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EstudianteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String nombreCompleto;
    private String legajo;
    private String email;
    private Long carrera_id;
}
package ar.edu.universidad.gestion.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProfesorDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String titulo;
    private Double sueldo;
}
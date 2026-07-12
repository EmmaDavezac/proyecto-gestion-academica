package ar.edu.universidad.gestion.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarreraDTO {
    private Long id;
    private String nombre;
    private Integer duracion;
}
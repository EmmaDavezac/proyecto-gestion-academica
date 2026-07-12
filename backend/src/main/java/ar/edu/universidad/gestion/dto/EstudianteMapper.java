package ar.edu.universidad.gestion.dto;

import ar.edu.universidad.gestion.model.Estudiante;
import ar.edu.universidad.gestion.model.Carrera;

public class EstudianteMapper {

    // Convierte Entidad a DTO (para enviar al frontend)
    public static EstudianteDTO toDTO(Estudiante e) {
        EstudianteDTO dto = new EstudianteDTO();
        dto.setId(e.getId());
        dto.setNombre(e.getNombre());
        dto.setApellido(e.getApellido());
        dto.setEmail(e.getEmail());
        dto.setLegajo(e.getLegajo());
        dto.setNombreCompleto(e.getNombre() + " " + e.getApellido());

        if (e.getCarrera() != null) {
            dto.setCarrera_id(e.getCarrera().getId());
        }

        return dto;
    }

    // Convierte DTO a Entidad (para guardar/actualizar en BD)
    public static void updateEntityFromDTO(Estudiante e, EstudianteDTO dto, Carrera carrera) {
        e.setNombre(dto.getNombre());
        e.setApellido(dto.getApellido());
        e.setEmail(dto.getEmail());
        e.setLegajo(dto.getLegajo());
        e.setCarrera(carrera);
    }
}
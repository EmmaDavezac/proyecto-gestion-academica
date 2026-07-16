package ar.edu.universidad.gestion.dto;

import ar.edu.universidad.gestion.model.Profesor;

public class ProfesorMapper {

    // Convierte Entidad a DTO (para enviar al frontend)
    public static ProfesorDTO toDTO(Profesor p) {
        ProfesorDTO dto = new ProfesorDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setApellido(p.getApellido());
        dto.setEmail(p.getEmail());
        dto.setTitulo(p.getTitulo());
        dto.setSueldo(p.getSueldo());


        return dto;
    }

    // Convierte DTO a Entidad (para guardar/actualizar en BD)
    public static void updateEntityFromDTO(Profesor e, ProfesorDTO dto) {
        e.setNombre(dto.getNombre());
        e.setApellido(dto.getApellido());
        e.setEmail(dto.getEmail());
        e.setTitulo(dto.getTitulo());
        e.setSueldo(dto.getSueldo());
    }
}
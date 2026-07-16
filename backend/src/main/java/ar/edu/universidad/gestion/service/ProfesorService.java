package ar.edu.universidad.gestion.service;

import ar.edu.universidad.gestion.dto.ProfesorDTO;
import ar.edu.universidad.gestion.model.Profesor;
import ar.edu.universidad.gestion.repository.ProfesorRepository;
import ar.edu.universidad.gestion.dto.ProfesorMapper; // Importamos nuestro mapper
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesorService {
    @Autowired
    private ProfesorRepository repository;


    public List<ProfesorDTO> listarTodos() {
        return repository.findAll().stream()
                .map(ProfesorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProfesorDTO guardar(ProfesorDTO dto) {

        // . Creamos la entidad y usamos el Mapper para actualizarla
        Profesor p = new Profesor();
       ProfesorMapper.updateEntityFromDTO(p, dto);

        // . Guardamos y retornamos el DTO
        return ProfesorMapper.toDTO(repository.save(p));
    }

    public ProfesorDTO obtenerPorId(Long id) {
        Profesor p = repository.findById(id).orElseThrow();
        return ProfesorMapper.toDTO(p); // Usamos el mapper aquí
    }

    public List<ProfesorDTO> buscarPorNombreOApellido(String texto) {
        // Llamamos al nuevo método con "Containing"
        return repository.findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(texto, texto).stream()
                .map(ProfesorMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ProfesorDTO actualizar(Long id, ProfesorDTO dto) {
        // 1. Buscamos el profesor existente
        Profesor p = repository.findById(id).orElseThrow();

        // 2. Usamos el Mapper para actualizar la entidad existente
       ProfesorMapper.updateEntityFromDTO(p, dto);

        // 3. Guardamos
        return ProfesorMapper.toDTO(repository.save(p));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

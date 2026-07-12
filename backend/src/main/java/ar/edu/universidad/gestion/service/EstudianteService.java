package ar.edu.universidad.gestion.service;

import ar.edu.universidad.gestion.dto.EstudianteDTO;
import ar.edu.universidad.gestion.model.Carrera;
import ar.edu.universidad.gestion.model.Estudiante;
import ar.edu.universidad.gestion.repository.CarreraRepository;
import ar.edu.universidad.gestion.repository.EstudianteRepository;
import ar.edu.universidad.gestion.dto.EstudianteMapper; // Importamos nuestro mapper
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EstudianteService {
    @Autowired
    private EstudianteRepository repository;

    @Autowired
    private CarreraRepository carreraRepository;

    public List<EstudianteDTO> listarTodos() {
        return repository.findAll().stream()
                .map(EstudianteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public EstudianteDTO guardar(EstudianteDTO dto) {
        // 1. Buscamos la carrera
        Carrera carrera = carreraRepository.findById(dto.getCarrera_id())
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        // 2. Creamos la entidad y usamos el Mapper para actualizarla
        Estudiante e = new Estudiante();
        EstudianteMapper.updateEntityFromDTO(e, dto, carrera);

        // 3. Guardamos y retornamos el DTO
        return EstudianteMapper.toDTO(repository.save(e));
    }

    public EstudianteDTO obtenerPorId(Long id) {
        Estudiante e = repository.findById(id).orElseThrow();
        return EstudianteMapper.toDTO(e); // Usamos el mapper aquí
    }

    public EstudianteDTO actualizar(Long id, EstudianteDTO dto) {
        // 1. Buscamos el estudiante existente
        Estudiante e = repository.findById(id).orElseThrow();

        // 2. Buscamos la carrera
        Carrera carrera = carreraRepository.findById(dto.getCarrera_id())
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        // 3. Usamos el Mapper para actualizar la entidad existente
        EstudianteMapper.updateEntityFromDTO(e, dto, carrera);

        // 4. Guardamos
        return EstudianteMapper.toDTO(repository.save(e));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

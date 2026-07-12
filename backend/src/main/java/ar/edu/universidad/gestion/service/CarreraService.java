package ar.edu.universidad.gestion.service;

import ar.edu.universidad.gestion.dto.CarreraDTO;
import ar.edu.universidad.gestion.model.Carrera;
import ar.edu.universidad.gestion.repository.CarreraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreraService {
    @Autowired
    private CarreraRepository repository;

    public List<CarreraDTO> listarTodos() {
        return repository.findAll().stream().map(e -> {
            CarreraDTO dto = new CarreraDTO();
            dto.setId(e.getId());
            dto.setNombre(e.getNombre());
            dto.setDuracion(e.getDuracion());
            return dto;
        }).toList();
    }

    public CarreraDTO guardar(CarreraDTO dto) {
        Carrera e = new Carrera();
        e.setNombre(dto.getNombre());
        e.setDuracion(dto.getDuracion());
        repository.save(e);
        return dto;
    }

    public CarreraDTO obtenerPorId(Long id) {
        Carrera e = repository.findById(id).orElseThrow(); // Lanza error si no existe
        CarreraDTO dto = new CarreraDTO();
        dto.setId(e.getId());
        dto.setNombre(e.getNombre());
        dto.setDuracion(e.getDuracion());
        return dto;
    }

    public CarreraDTO actualizar(Long id, CarreraDTO dto) {
        Carrera e = repository.findById(id).orElseThrow();
        e.setNombre(dto.getNombre());
        e.setDuracion(dto.getDuracion());
        repository.save(e);
        return dto;
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}


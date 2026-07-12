package ar.edu.universidad.gestion.controller;

import ar.edu.universidad.gestion.dto.CarreraDTO;
import ar.edu.universidad.gestion.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carreras")
public class CarreraController {
    @Autowired
    private CarreraService service;

    @GetMapping
    public List<CarreraDTO> obtenerTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public CarreraDTO crear(@RequestBody CarreraDTO dto) {
        return service.guardar(dto);
    }

    @GetMapping("/{id}")
    public CarreraDTO obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public CarreraDTO actualizar(@PathVariable Long id, @RequestBody CarreraDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}


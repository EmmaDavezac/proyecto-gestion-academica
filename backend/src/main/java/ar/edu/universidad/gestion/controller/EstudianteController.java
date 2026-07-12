package ar.edu.universidad.gestion.controller;

import ar.edu.universidad.gestion.dto.EstudianteDTO;
import ar.edu.universidad.gestion.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService service;

    @Operation(summary = "Obtiene el listado completo de estudiantes")
    @GetMapping
    public List<EstudianteDTO> obtenerTodos() {
        return service.listarTodos();
    }

    @Operation(summary = "Crea un nuevo estudiante")
    @ApiResponse(responseCode = "201", description = "Estudiante creado con éxito")
    @PostMapping
    public ResponseEntity<EstudianteDTO> crear(@RequestBody EstudianteDTO dto) {
        EstudianteDTO nuevo = service.guardar(dto);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }
    @Operation(summary = "Obtiene un estudiante a partir del ID")
    @ApiResponse(responseCode = "201", description = "Estudiante obtenido con exito")
    @GetMapping("/{id}")
    public EstudianteDTO obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }
    @Operation(summary = "Actualiza un estudiante a partir del ID")
    @ApiResponse(responseCode = "201", description = "Estudiante actualizado con exito")
    @PutMapping("/{id}")
    public EstudianteDTO actualizar(@PathVariable Long id, @RequestBody EstudianteDTO dto) {
        return service.actualizar(id, dto);
    }

    @Operation(summary = "Elimina un estudiante a partir del ID")
    @ApiResponse(responseCode = "201", description = "Estudiante eliminado con exito")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}


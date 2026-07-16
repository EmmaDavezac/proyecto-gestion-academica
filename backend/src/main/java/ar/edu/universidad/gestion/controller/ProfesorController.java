package ar.edu.universidad.gestion.controller;

import ar.edu.universidad.gestion.dto.ProfesorDTO;
import ar.edu.universidad.gestion.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {
    @Autowired
    private ProfesorService service;

    @Operation(summary = "Obtiene el listado completo de profesores")
    @GetMapping
    public List<ProfesorDTO> obtenerTodos() {
        return service.listarTodos();

    }


    @Operation(summary = "Crea un nuevo profesor")
    @ApiResponse(responseCode = "201", description = "Profesor creado con éxito")
    @PostMapping
    public ResponseEntity<ProfesorDTO> crear(@RequestBody ProfesorDTO dto) {
        ProfesorDTO nuevo = service.guardar(dto);
        return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
    }
    @Operation(summary = "Obtiene un profesor a partir del ID")
    @ApiResponse(responseCode = "201", description = "Profesor obtenido con exito")
    @GetMapping("/{id}")
    public ProfesorDTO obtenerPorId(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }
    @Operation(summary = "Actualiza un profesor a partir del ID")
    @ApiResponse(responseCode = "201", description = "Profesor actualizado con exito")
    @PutMapping("/{id}")
    public ProfesorDTO actualizar(@PathVariable Long id, @RequestBody ProfesorDTO dto) {
        return service.actualizar(id, dto);
    }

    @Operation(summary = "Busca profesores por nombre o por apellido")
    @ApiResponse(responseCode = "200", description = "Búsqueda realizada con éxito")
    @GetMapping("/search")
    public List<ProfesorDTO> buscar(@RequestParam String nombreOApellido) {
        return service.buscarPorNombreOApellido(nombreOApellido);
    }

    @Operation(summary = "Elimina un profesor a partir del ID")
    @ApiResponse(responseCode = "201", description = "Profesor eliminado con exito")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}


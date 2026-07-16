package ar.edu.universidad.gestion.repository;

import ar.edu.universidad.gestion.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {

    // Derived Query Method unificado con OR
    List<Profesor> findByNombreContainingIgnoreCaseOrApellidoContainingIgnoreCase(String nombre, String apellido);
}
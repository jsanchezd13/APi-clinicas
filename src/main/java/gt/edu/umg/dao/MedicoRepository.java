package gt.edu.umg.dao;

import gt.edu.umg.core.entities.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    // Buscar por matrícula (única)
    Optional<Medico> findByMatricula(String matricula);

    // Buscar por especialidad
    List<Medico> findByEspecialidadContainingIgnoreCase(String especialidad);

    Optional<Medico> findByEmail(String email);

    // Buscar por nombre
    List<Medico> findByNombreContainingIgnoreCase(String nombre);

    // Buscar por nombre y apellido
    List<Medico> findByNombreContainingIgnoreCaseAndApellidoContainingIgnoreCase(String nombre, String apellido);

    // Buscar médicos activos
    List<Medico> findByActivoTrue();

    // Buscar por especialidad y activos
    List<Medico> findByEspecialidadContainingIgnoreCaseAndActivoTrue(String especialidad);

    // Todos ordenados por nombre
    List<Medico> findAllByOrderByNombreAsc();

    // Verificar si existe por matrícula
    boolean existsByMatricula(String matricula);

    // Verificar si existe por matrícula excluyendo un ID
    @Query("SELECT COUNT(m) > 0 FROM Medico m WHERE m.matricula = :matricula AND m.id != :id")
    boolean existsByMatriculaAndIdNot(@Param("matricula") String matricula, @Param("id") Long id);

    // Verificar si existe por email
    boolean existsByEmail(String email);

    // Verificar si existe por email excluyendo un ID
    @Query("SELECT COUNT(m) > 0 FROM Medico m WHERE m.email = :email AND m.id != :id")
    boolean existsByEmailAndIdNot(@Param("email") String email, @Param("id") Long id);
}
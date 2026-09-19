package gt.edu.umg.dao;

import gt.edu.umg.core.entities.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Long> {

    List<Receta> findByPacienteId(Long pacienteId);

    List<Receta> findByMedicoId(Long medicoId);

    List<Receta> findByCitaId(Long citaId);

    List<Receta> findByFechaEmisionBetween(LocalDateTime inicio, LocalDateTime fin);

    @Query("SELECT r FROM Receta r WHERE r.paciente.id = :pacienteId ORDER BY r.fechaEmision DESC")
    List<Receta> findUltimasRecetasByPaciente(@Param("pacienteId") Long pacienteId);

    @Query("SELECT r FROM Receta r WHERE r.fechaVencimiento < CURRENT_DATE AND r.activo = true")
    List<Receta> findRecetasVencidas();
}
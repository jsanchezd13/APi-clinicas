<<<<<<< HEAD
package gt.edu.umg.dao;

import gt.edu.umg.core.entities.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

    // Buscar por paciente
    List<Cita> findByPacienteId(Long pacienteId);

    // Buscar por médico
    List<Cita> findByMedicoId(Long medicoId);

    // Buscar por estado
    List<Cita> findByEstado(String estado);

    // Buscar citas en un rango de fechas
    List<Cita> findByFechaHoraBetween(LocalDateTime inicio, LocalDateTime fin);

    // Buscar citas de un médico en un rango de fechas
    List<Cita> findByMedicoIdAndFechaHoraBetween(Long medicoId, LocalDateTime inicio, LocalDateTime fin);

    // Buscar citas de un paciente en un rango de fechas
    List<Cita> findByPacienteIdAndFechaHoraBetween(Long pacienteId, LocalDateTime inicio, LocalDateTime fin);

    // Buscar citas activas
    List<Cita> findByActivoTrue();

    // Buscar citas por estado y activas
    List<Cita> findByEstadoAndActivoTrue(String estado);

    // Buscar citas futuras de un paciente
    @Query("SELECT c FROM Cita c WHERE c.paciente.id = :pacienteId AND c.fechaHora > :now AND c.activo = true ORDER BY c.fechaHora ASC")
    List<Cita> findCitasFuturasByPaciente(@Param("pacienteId") Long pacienteId, @Param("now") LocalDateTime now);

    // Buscar citas futuras de un médico
    @Query("SELECT c FROM Cita c WHERE c.medico.id = :medicoId AND c.fechaHora > :now AND c.activo = true ORDER BY c.fechaHora ASC")
    List<Cita> findCitasFuturasByMedico(@Param("medicoId") Long medicoId, @Param("now") LocalDateTime now);

    // Verificar si hay citas en un horario específico para un médico
    @Query("SELECT COUNT(c) > 0 FROM Cita c WHERE c.medico.id = :medicoId AND c.fechaHora = :fechaHora AND c.activo = true")
    boolean existsByMedicoAndFechaHora(@Param("medicoId") Long medicoId, @Param("fechaHora") LocalDateTime fechaHora);

    // Contar citas por estado
    @Query("SELECT c.estado, COUNT(c) FROM Cita c GROUP BY c.estado")
    List<Object[]> countCitasByEstado();
=======
package gt.edu.umg.dao;

import gt.edu.umg.core.entities.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Long> {

    // Buscar por paciente
    List<Cita> findByPacienteId(Long pacienteId);

    // Buscar por médico
    List<Cita> findByMedicoId(Long medicoId);

    // Buscar por estado
    List<Cita> findByEstado(String estado);

    // Buscar citas en un rango de fechas
    List<Cita> findByFechaHoraBetween(LocalDateTime inicio, LocalDateTime fin);

    // Buscar citas de un médico en un rango de fechas
    List<Cita> findByMedicoIdAndFechaHoraBetween(Long medicoId, LocalDateTime inicio, LocalDateTime fin);

    // Buscar citas de un paciente en un rango de fechas
    List<Cita> findByPacienteIdAndFechaHoraBetween(Long pacienteId, LocalDateTime inicio, LocalDateTime fin);

    // Buscar citas activas
    List<Cita> findByActivoTrue();

    // Buscar citas por estado y activas
    List<Cita> findByEstadoAndActivoTrue(String estado);

    // Buscar citas futuras de un paciente
    @Query("SELECT c FROM Cita c WHERE c.paciente.id = :pacienteId AND c.fechaHora > :now AND c.activo = true ORDER BY c.fechaHora ASC")
    List<Cita> findCitasFuturasByPaciente(@Param("pacienteId") Long pacienteId, @Param("now") LocalDateTime now);

    // Buscar citas futuras de un médico
    @Query("SELECT c FROM Cita c WHERE c.medico.id = :medicoId AND c.fechaHora > :now AND c.activo = true ORDER BY c.fechaHora ASC")
    List<Cita> findCitasFuturasByMedico(@Param("medicoId") Long medicoId, @Param("now") LocalDateTime now);

    // Verificar si hay citas en un horario específico para un médico
    @Query("SELECT COUNT(c) > 0 FROM Cita c WHERE c.medico.id = :medicoId AND c.fechaHora = :fechaHora AND c.activo = true")
    boolean existsByMedicoAndFechaHora(@Param("medicoId") Long medicoId, @Param("fechaHora") LocalDateTime fechaHora);

    // Contar citas por estado
    @Query("SELECT c.estado, COUNT(c) FROM Cita c GROUP BY c.estado")
    List<Object[]> countCitasByEstado();
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
}
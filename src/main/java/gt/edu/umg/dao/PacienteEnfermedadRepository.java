package gt.edu.umg.dao;

import gt.edu.umg.core.entities.PacienteEnfermedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteEnfermedadRepository extends JpaRepository<PacienteEnfermedad, Long> {

    List<PacienteEnfermedad> findByPacienteId(Long pacienteId);

    List<PacienteEnfermedad> findByEnfermedadId(Long enfermedadId);

    List<PacienteEnfermedad> findByPacienteIdAndEstado(Long pacienteId, String estado);

    boolean existsByPacienteIdAndEnfermedadId(Long pacienteId, Long enfermedadId);

}
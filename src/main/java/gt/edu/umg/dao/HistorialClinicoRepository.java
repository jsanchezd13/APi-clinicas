package gt.edu.umg.dao;

import gt.edu.umg.core.entities.HistorialClinico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistorialClinicoRepository extends JpaRepository<HistorialClinico, Long> {

    List<HistorialClinico> findByPacienteId(Long pacienteId);

    List<HistorialClinico> findByMedicoId(Long medicoId);

    List<HistorialClinico> findByPacienteIdAndActivoTrue(Long pacienteId);
}
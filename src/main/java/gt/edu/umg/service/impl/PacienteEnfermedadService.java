
package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.PacienteEnfermedad;
import java.util.List;

public interface PacienteEnfermedadService {

    PacienteEnfermedad guardar(PacienteEnfermedad entity);

    List<PacienteEnfermedad> obtenerTodos();

    PacienteEnfermedad obtenerPorId(Long id);

    PacienteEnfermedad actualizar(Long id, PacienteEnfermedad entity);

    void eliminar(Long id);

    List<PacienteEnfermedad> buscarPorPaciente(Long pacienteId);

    List<PacienteEnfermedad> buscarPorEnfermedad(Long enfermedadId);

    boolean existeRelacion(Long pacienteId, Long enfermedadId);

}
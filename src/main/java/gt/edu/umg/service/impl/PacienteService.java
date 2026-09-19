// PacienteService.java (interfaz)
package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.Paciente;
import gt.edu.umg.core.entities.Dtos.Request.PacienteFilter;
import org.springframework.data.domain.Page;

public interface PacienteService {
    Paciente guardar(Paciente paciente);
    Page<Paciente> buscarConFiltros(PacienteFilter filter);
    Paciente obtenerPorId(Long id);
    void eliminar(Long id);
}

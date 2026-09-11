<<<<<<< HEAD
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
=======
package gt.edu.umg.service.impl;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import gt.edu.umg.core.entities.Paciente;

public interface PacienteService {
	Paciente guardar(Paciente paciente);
    List<Paciente> obtenerTodos();
    Paciente obtenerPorId(Long id);
    void eliminar(Long id);
    
    // Método para consultas dinámicas (Queryable)
    List<Paciente> buscarConFiltro(Specification<Paciente> spec);
}
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943

<<<<<<< HEAD
package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.HistorialClinico;
import java.util.List;

public interface HistorialClinicoService {

    HistorialClinico guardar(HistorialClinico entity);

    List<HistorialClinico> obtenerTodos();

    HistorialClinico obtenerPorId(Long id);

    HistorialClinico actualizar(Long id, HistorialClinico entity);

    void eliminar(Long id);

    List<HistorialClinico> buscarPorPaciente(Long pacienteId);

    List<HistorialClinico> buscarPorMedico(Long medicoId);
=======
package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.HistorialClinico;
import java.util.List;

public interface HistorialClinicoService {

    HistorialClinico guardar(HistorialClinico entity);

    List<HistorialClinico> obtenerTodos();

    HistorialClinico obtenerPorId(Long id);

    HistorialClinico actualizar(Long id, HistorialClinico entity);

    void eliminar(Long id);

    List<HistorialClinico> buscarPorPaciente(Long pacienteId);

    List<HistorialClinico> buscarPorMedico(Long medicoId);
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
}
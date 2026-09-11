<<<<<<< HEAD
package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.RecetaMedicamento;
import java.util.List;

public interface RecetaMedicamentoService {

    RecetaMedicamento guardar(RecetaMedicamento entity);

    List<RecetaMedicamento> obtenerTodos();

    RecetaMedicamento obtenerPorId(Long id);

    RecetaMedicamento actualizar(Long id, RecetaMedicamento entity);

    void eliminar(Long id);

    List<RecetaMedicamento> buscarPorReceta(Long recetaId);

    List<RecetaMedicamento> buscarPorMedicamento(Long medicamentoId);

    boolean existeRelacion(Long recetaId, Long medicamentoId);
=======
package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.RecetaMedicamento;
import java.util.List;

public interface RecetaMedicamentoService {

    RecetaMedicamento guardar(RecetaMedicamento entity);

    List<RecetaMedicamento> obtenerTodos();

    RecetaMedicamento obtenerPorId(Long id);

    RecetaMedicamento actualizar(Long id, RecetaMedicamento entity);

    void eliminar(Long id);

    List<RecetaMedicamento> buscarPorReceta(Long recetaId);

    List<RecetaMedicamento> buscarPorMedicamento(Long medicamentoId);

    boolean existeRelacion(Long recetaId, Long medicamentoId);
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
}
package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.Medicamento;
import java.util.List;

public interface MedicamentoService {

    Medicamento guardar(Medicamento entity);

    List<Medicamento> obtenerTodos();

    Medicamento obtenerPorId(Long id);

    Medicamento actualizar(Long id, Medicamento entity);

    void eliminar(Long id);

    List<Medicamento> buscarPorNombre(String nombre);

    List<Medicamento> buscarPorCategoria(String categoria);

    List<Medicamento> buscarPorLaboratorio(String laboratorio);

    List<Medicamento> buscarActivos();

    List<Medicamento> buscarConReceta();
}
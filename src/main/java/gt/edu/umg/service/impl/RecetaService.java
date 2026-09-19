package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.Receta;
import java.time.LocalDateTime;
import java.util.List;

public interface RecetaService {

    Receta guardar(Receta entity);

    List<Receta> obtenerTodos();

    Receta obtenerPorId(Long id);

    Receta actualizar(Long id, Receta entity);

    void eliminar(Long id);

    List<Receta> buscarPorPaciente(Long pacienteId);

    List<Receta> buscarPorMedico(Long medicoId);

    List<Receta> buscarPorCita(Long citaId);

    List<Receta> buscarPorRangoFechas(LocalDateTime inicio, LocalDateTime fin);

    List<Receta> buscarUltimasPorPaciente(Long pacienteId);

    List<Receta> buscarRecetasVencidas();
}
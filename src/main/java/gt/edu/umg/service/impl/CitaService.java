<<<<<<< HEAD
package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.Cita;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaService {

    // CRUD básico
    Cita guardar(Cita cita);

    List<Cita> obtenerTodos();

    Cita obtenerPorId(Long id);

    void eliminar(Long id);

    Cita actualizar(Long id, Cita citaActualizada);

    // Consultas específicas
    List<Cita> buscarPorPaciente(Long pacienteId);

    List<Cita> buscarPorMedico(Long medicoId);

    List<Cita> buscarPorEstado(String estado);

    List<Cita> buscarPorRangoFechas(LocalDateTime inicio, LocalDateTime fin);

    List<Cita> buscarCitasFuturasPorPaciente(Long pacienteId);

    List<Cita> buscarCitasFuturasPorMedico(Long medicoId);

    List<Cita> buscarActivos();

    boolean existeCitaEnHorario(Long medicoId, LocalDateTime fechaHora);

    // Métodos de gestión de estado
    Cita confirmarCita(Long id);

    Cita completarCita(Long id);

    Cita cancelarCita(Long id);
=======
package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.Cita;

import java.time.LocalDateTime;
import java.util.List;

public interface CitaService {

    // CRUD básico
    Cita guardar(Cita cita);

    List<Cita> obtenerTodos();

    Cita obtenerPorId(Long id);

    void eliminar(Long id);

    Cita actualizar(Long id, Cita citaActualizada);

    // Consultas específicas
    List<Cita> buscarPorPaciente(Long pacienteId);

    List<Cita> buscarPorMedico(Long medicoId);

    List<Cita> buscarPorEstado(String estado);

    List<Cita> buscarPorRangoFechas(LocalDateTime inicio, LocalDateTime fin);

    List<Cita> buscarCitasFuturasPorPaciente(Long pacienteId);

    List<Cita> buscarCitasFuturasPorMedico(Long medicoId);

    List<Cita> buscarActivos();

    boolean existeCitaEnHorario(Long medicoId, LocalDateTime fechaHora);

    // Métodos de gestión de estado
    Cita confirmarCita(Long id);

    Cita completarCita(Long id);

    Cita cancelarCita(Long id);
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
}